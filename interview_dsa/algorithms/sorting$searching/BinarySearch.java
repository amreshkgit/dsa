package algorithms.sorting$searching;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterative and Recursive way to do binary search
 * <p>
 * TIME COMPLEXITY CALCULATION
 * Length of array = n
 * At Iteration 2,
 * <p>
 * Length of array = n⁄2
 * At Iteration 3,
 * <p>
 * Length of array = (n⁄2)⁄2 = n⁄2^2
 * Therefore, after Iteration k,
 * <p>
 * Length of array = n⁄2^k
 * Also, we know that after
 * <p>
 * After k iterations, the length of array becomes 1
 * Therefore
 * <p>
 * Length of array = n⁄2^k=1
 * => n = 2^k
 * Applying log function on both sides:
 * <p>
 * => log2 (n) = log2 (2^k)
 * => log2 (n) = k log2^(2)
 * <p>
 * <p>
 * As (loga (a) = 1)
 * Therefore,
 * <p>
 * => k = log2 (n)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 4, 5, 6, 7, 8, 10};
        int[] array1 = {2, 4, 10, 10, 10, 18, 20};
        int[] rotatedArray = {15, 22, 23, 28, 31, 5, 6, 8, 10, 12};
        /*int index = binarySearchIterative(array,7,11);
        System.out.println(index!=-1 ? array[index]+" found in array":"Not Found");
        int index1 = binarySearchRecursive(array,0,7,8);
        System.out.println(index1!=-1 ? array[index1]+" found in array":"Not Found");*/
          int index2 = binarySearchIterativeToFindFirstAndLastOccurrenceOfNumber(array1,7,10,true);
         System.out.println("Found at index "+index2);
        //int noOfRotation = findRotationCount(rotatedArray,10);
        //System.out.println("Number of rotation :: "+noOfRotation);
        //  int[] nearlySortedArray={5,10,30,20,40};
        //System.out.println(findElementInNearlySortedArray(nearlySortedArray,0,5,5));
        char[] c = {'a', 'c', 'f', 'h'};
        System.out.println(NextAlphabeticalElement(c, 'c'));
        System.out.println(searchInSortedRotatedArray(rotatedArray,8));
    }

    //Time complexity O(logn)
    static int binarySearchIterative(int[] A, int n, int x) {
        int start = 0, end = n - 1;
        while (start <= end) {
            //This better approach to do that because sometimes low+high exceeds the maximum value that an integer can store
            // so like, 32-bit integer , 32-bit a signed integer can store maximum value of 2^31. if both low and high is at
            //pretty high then (high+low) will exceed 2^31 and can cause issue in the program execution.
            int mid = start + (end - start) / 2;
            //int mid = (low+high)/2; //cause may overflow
            if (x == A[mid]) return mid;
            else if (x < A[mid])
                end = mid - 1;//x lies before mid ,means go left search to array
            else
                start = mid + 1; //x lies after mid, means search to right
        }
        return -1;
    }


    /**
     * The time taken to proportional to logn and it comes from the fact that if we keep dividing
     * the size of the array
     * by 2 at each step then it will take us logn step to reach array size to 1.
     * Iterative way is slightly more better in terms of performance because we do not have
     * to store all these states of these
     * function, the extra function in the memory. In practical scenario we can use any of
     * them based on our comfort to choose.
     *
     * @param A
     * @param low
     * @param high
     * @param x
     * @return
     */
    static int binarySearchRecursive(int[] A, int low, int high, int x) {
        //Base condition
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (x == A[mid])
            return mid;
        else if (x < A[mid])
            return binarySearchRecursive(A, low, mid - 1, x);
        else
            return binarySearchRecursive(A, mid + 1, high, x);

    }

    /**
     * Time complexity is O(logn)
     * Count occurrences of a number in a sorted array with duplicates using Binary Search
     * You can use this method to find the last index and first index then calculate(lastIndex-firstIndex+1)
     * if(firstIndex==-1)then simply return 0 and no need to go to lastIndex to check
     *
     * @param A
     * @param n
     * @param x
     * @return
     */
    static int binarySearchIterativeToFindFirstAndLastOccurrenceOfNumber(int[] A, int n, int x, boolean searchFlag) {
        int low = 0, high = n - 1, result = -1;
        List<Integer> res = new ArrayList<>();
        while (low <= high) {
            //This better approach to do that because sometimes low+high exceeds the maximum value that an integer can store
            // so like, 32-bit integer , 32-bit a signed integer can store maximum value of 2^31. if both low and high is at
            //pretty high then (high+low) will exceed 2^31 and can cause issue in the program execution.
            int mid = low + (high - low) / 2;
            //int mid = (low+high)/2; //cause may overflow
            if (x == A[mid]) {
                result = mid; //store the index of the found element
                if (searchFlag) {
                    high = mid - 1;//to get the first occurrence and to continue search on the left hand side
                } else
                    low = mid + 1;// to get the last occurrence and to continue search on the right hand side
            } else if (x < A[mid]) high = mid - 1;//x lies before mid means go left search to array
            else low = mid + 1; //x lies after mid
        }
        System.out.println("Result: " + res);
        return result;
    }

    /**
     * number of rotation equal to index of minimum number in the array
     * Trick ye hai ki minimum element find karo array me and uska index dega number of rotation
     * aur minimum element milega humko unsorted half of the array in the given array
     * yadi left sorted to right unsorted and vice versa
     *
     * minimum element has special condtion that will be smaller from his neighbour meaning
     * let and right
     *
     * input 11, 12, 15, 18 , 2, 5, 6,8
     * @param A
     * @param n
     * @return
     */

    static int findRotationCount(int[] A, int n) {
        int start = 0, end = n - 1;
        while (start <= end) {
            //This case will happen when array is already sorted
            if (A[start] <= A[end]) return start; //case 1
            int mid = (start + end) / 2;
            //if mid is last element then module operation does that
            int next = (mid + 1) % n, // Yahan pe modulo isliye kar rahe yadi hamara mid last index ko point kar raha ho
                    //aur hum mid+1 karenge to ye index out of bound ho jayega to isko avoid karne ka kiye
                    prev = (mid + n - 1) % n; // for prev me -1 me cahala jayega and ye modulo karne ka baad ghum ka last end index pe chala jayega
                   // yanhan pe mid me n add kiye kyun ki yadi mid 0 hoga to 0-1 jo hao wo -1 dega aur -1 pe modulo nahi kar sakte
            if (A[mid] <= A[next] && A[mid] <= A[prev]) { //case 2 when mid element is less than next and previous
                return mid; // to minimum element in the rotated array
            } else if (A[start] <= A[mid]) { //case 3 yadi start is less then mid hoga to left side array sorted hai
                start = mid + 1; // go to right side array which is unsorted which has minimum element
            } else if (A[mid] <= A[end]) { //case 4 yadi end less then mid hoga to right side of +
                // array will sorted and left will be unsorted
                end = mid - 1; // got to left hand side array to get the minimum element
            }
        }
        return -1;
    }

    // Problem -Count of an element in a sorted array
    /**
     * Trick to solve the problem
     * find position of first and last occurrence of an element
     * by using binary search
     * first call of binary search will give first occurrence and second call will give last occurrence
     * then lastOccurrenceIndex-firstOccurrenceIndex+1 will give the count of element in sorted array
     *
     * @return
     */
    static int countAnElementInSortedArray(int[] a, int arraySize, int searchElement) {
        int firstIndex = binarySearchIterativeToFindFirstAndLastOccurrenceOfNumber(a, arraySize, searchElement, true);
        int lastIndex = binarySearchIterativeToFindFirstAndLastOccurrenceOfNumber(a, arraySize, searchElement, false);
        return lastIndex - firstIndex + 1;
    }


    //Problem - Find element in Rotated sorted array
    /**
     * Trick to solve the problem
     * First get the index of the minimum element in the array using findRotationCount
     * then divide array in two first half will go start to mid-1
     * and second will mid to arraySize-1
     * and then do  binarySearch in two different array to get the element
     *
     * @return
     */
    static int findElementInRotatedSortedArray(int[] a, int arraySize) {
        int index = findRotationCount(a, arraySize);
        int index1 = binarySearchRecursive(a, 0, index - 1, 10);
        int index2 = binarySearchRecursive(a, index, arraySize - 1, 10);
        if (index1 != -1) {
            return index1;
        } else return index2;
    }

    //Problem - Find element in nearly sorted array
    /**
     * Tick to solve the problem
     * In nearly sorted array element can be found at ith position or i-1 position or i+1 position
     * but in regular binary search
     * element is always found at i position i.e mid and we compare with element.
     * But, here in this case,we need compare element with
     * mid, mid-1 & mid+1. and we have to add mid-1 >= start & mid+1 < end
     * check to avoid segmentation fault or out of bound
     *
     * @return
     */
    static int findElementInNearlySortedArray(int[] a, int start, int end, int searchElement) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (searchElement == a[mid]) {
                return mid;
            }
            if (mid - 1 >= start && a[mid - 1] == searchElement) {
                return mid - 1;
            }
            if (mid + 1 < end && a[mid + 1] == searchElement) {
                return mid + 1;
            }
            if (searchElement < a[mid]) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }
        return -1;
    }

    //Problem To find the floor of an element in the sorted array
    /**
     * Trick to solve the problem
     * We will do the regular binary search and once we first find the lesser element than search element
     * then we will be hunting the next greater element then found lesser element until we find the next greater
     * but lesser than search element
     * for example array {1,2,3,4,8,10,10,12,19} , searchElement = 5
     * here we get the mid which will 8 then we search will move to left hand of 8 then after calculation of
     * mid will hit first lesser element then 5 will be 2 and will store 2 in the result. but will hunt for
     * next greater element then 2 which fall on the right hand side of element 2. then next greater element
     * will be 3 and soon and we will end up finding 4 as a floor of 5.
     * our answer here will be 4.
     *
     * @param a
     * @param start
     * @param end
     * @param searchElement
     * @return
     */
    static int findTheFloorOfAnElementInSortedArray(int[] a, int start, int end, int searchElement) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] < searchElement) {
                res = a[mid]; // we are storing the result i.e our ans candidate before moving the right hand side
                start = mid + 1;
            } else if (a[mid] > searchElement) {
                end = mid - 1;
            }
        }
        return res;
    }

    //Problem To find the floor of an element in the sorted array
    /**
     * Trick to solve the problem
     * Ceil of 5 = The Smallest element which greater than 5
     * We will do the regular binary search and once we first find the lesser element than search element
     * then we will be hunting the next greater element then found lesser element until we find the next greater
     * but lesser than search element
     * for example array {1,2,3,4,8,10,10,12,19} , searchElement = 5
     * here we get the mid which will 8 then we search will move to left hand of 8 then after calculation of
     * mid will hit first lesser element then 5 will be 2 and will store 2 in the result. but will hunt for
     * next greater element then 2 which fall on the right hand side of element 2. then next greater element
     * will be 3 and soon and we will end up finding 4 as a floor of 5.
     * our answer here will be 4.
     *
     * @param a
     * @param start
     * @param end
     * @param searchElement
     * @return
     */
    static int findTheCeilOfAnElementInSortedArray(int[] a, int start, int end, int searchElement) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == searchElement) {
                return a[mid];
            } else if (a[mid] < searchElement) {
                start = mid + 1;
            } else if (a[mid] > searchElement) {
                res = a[mid]; // we are storing the result i.e our ans candidate before moving the left hand side
                end = mid - 1;
            }
        }
        return res;
    }

    //Problem Next Alphabetical element
    static char NextAlphabeticalElement(char[] c, char key) {
        int start = 0, end = c.length - 1;
        char res = 0; //The 0 in ASCII-Code is null.
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (c[mid] > key) { // when key is smaller
                res = c[mid];
                end = mid - 1;
            } else { // when key is greater
                start = mid + 1;
            }
        }
        return res;
    }

    // Problem Find position of an element in an Infinite Sorted Array
    /**
     * Tick to solve the problem
     * int[] array ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,16......infinite} here key=7
     * As we know for binarySearch to perform we need start and end index but
     * for infinite sorted array we have start but we dont have idea about end index as it infnite.
     * here , challenge is to get the end index ?
     * So, first we will initialize start to first index that is 0 and end to second index that is 1
     * start=0, and end =1;
     * then compare searchElement with end index element if it is greater than end index element then end multiply by 2
     * i.e end = end * 2 and start will be at end index, i.e. start=1 so, it will become start=1 and end=2
     * and next iteration start=1 and end = 2 and again we will compare end with searchElement it again greater
     * than end index element then we will do end = end*2 => end = 2*2=4 so, now end=4 and
     * start will point to end index
     * start=2 so, it will become start=2 and end=4 soon
     *
     * @return
     */
    static int FindPositionOfAnElementInAInfiniteSortedArray(int[] a, int key) {
        int start = 0;
        int end = 1;
        while (key > a[end]) {
            start = end;
            end = end * 2;
        }
        // perform binarySearch based on start and end from above
        int res = binarySearchRecursive(a, start, end, key);
        return res;
    }

    //Problem Minimum diff element in a sorted Array
    /**
     * Trick to solve the problem
     * In this problem just apply the regular binary search
     * As per binary property when binary search loop ends then
     * high will point to second last element and low will point to
     * last element when our search continue to right hand side.
     * <p>
     * Using this property we will find the minimum difference element
     * @param a
     * @return
     */
    static int minimumDiffElementInSortedArray(int[] a, int key) {
        int start = 0, end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                end = mid - 1;
            } else {
                end = mid + 1;
            }
        }
        return -1;
    }

    //Peak Element from unsorted array
    /**
     * Trick to solve the problem
     * step 1
     * first we have to search the element within search boundary, so our search boundary
     * will the element excluding first and last element in the array
     * and criteria to find the peak element is , that element will greater than it's neighbour
     * i.e. mid-1 and mid+1
     * step 2
     * Run through the edge element which we have excluded in step 1
     * @param a
     * @param peakElement
     * @return
     */
    static int peakElement(int[]a, int peakElement){
        int low = 0, high=a.length-1;
        while (low<=high){
             int mid = low + (high-low)/2;

             //step 1
             if(mid > 0 && mid < a.length-1)// created the search boundary
             {
                 if(a[mid] > a[mid-1] && a[mid] > a[mid+1] ){
                     return mid;
                 }else if(a[mid-1] > a[mid]){
                     high= mid-1;
                 }else{
                     low = mid+1;
                 }
             }
             //step 2
             else if(mid ==0){
                 if(a[0] > a[1]){
                     return 0;
                 }
                 else{return 1;}

             }else if(mid == a.length-1){
                 if(a[a.length-1] > a[a.length-2]){
                     return a.length-1;
                 }else {
                   return   a.length-2;
                 }
             }
        }
        return -1;
    }

    static int circularArraySearch(int[] A, int n, int x) {
        int low = 0, high = n - 1;
        while (low <= high) { //while segment or search space is valid
            int mid = low + (high - low) / 2;

            if (x == A[mid]) return A[mid];// case 1 found

            if (A[mid] <= A[high]) { //case 2 : right half is sorted
                if (x > A[mid] && x <= A[high])
                    low = mid + 1; //go searching in right sorted half
                else
                    high = mid - 1; // go searching left
            } else {  //case 3. Left half is sorted
                if (A[mid] <= x && x < A[mid]) // go searching in left sorted half
                    high = mid - 1;
                else
                    low = mid + 1; //go searching right
            }
        }
        return -1;
    }

        public static int searchInSortedRotatedArray(int a[] , int key){
         int low =0, high=a.length-1;
         while (low <= high){
             int mid = low + (high - low) / 2;
             if (key == a[mid]) return a[mid];
            if(a[low] < a[mid]){ // left part is sorted
                if(key >= a[low] && key < a[mid]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }else{ // right part is sorted
                if(key > a[mid] && key <= a[high]){
                    low = mid +1;
                }else{
                    high = mid -1;
                }
            }
         }
         return -1;
        }

}
