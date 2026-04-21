package algorithms.sorting$searching;

import java.util.stream.IntStream;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {2, 7, 4, 1, 5, 3};
        int[] A1 = {2, 7, 4, 1, 5, 3};
        bubbleSort(A);
        IntStream.of(A).boxed().forEach(x -> System.out.print(x + " "));
        //bubbleSortImprovement(A1);
        //IntStream.of(A).boxed().forEach(x-> System.out.print(x +" "));
    }

    /**
     * These are slow sorting algorithm
     * Time complexity analysis
     * T(n) = (n-1)*(n-1)*c
     * = cn^2-2cn+1 //Polynomial function always will give O(n^2)
     * = O(n^2)
     * <p>
     * we can do couple of things in this algorithm to improve the time complexity at least for some
     * scenarios. The first thing that we can do is, we need not run this second loop till (n-2), all the time
     * At any stage during the sorting , the array will have some part as sorted and some part as unsorted.
     * There is no point passing through the sorted part because there will no swapping in that part.For first pass we
     * can run this inner loop till (n-2), for second pass we can run this inner loop till n-3 and we will be good.
     * For third pass, we can only run till n-4 and soon.
     * So, in general we can run the loop till (n-k-1)  for(int j=0;j<n-k-1;j++)
     * <p>
     * we can do something else to improve the performance see the below
     * 2,7,4,1,5,3
     * => 2,4,1,5,3,7
     * => 2,1,4,3,5,7
     * => 1,2,3,4,5,7
     * So, Here no changes after pass 4 & 5 . So, if list is already sorted , there would be no swaps.So, if
     * we go through a pass without swapping anything, then definitely at that stage the list is already sorted.
     */
    static void bubbleSort(int[] A) {
        int n = A.length;
        //After n-1 pass we guarantee to be sorted
        for (int k = 1; k <= n - 1; k++) { //this will run n-1 times
            for (int i = 0; i <= n - 2; i++) { //this will run n-1 times
                /* start*/
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
                /* End say it will take some constant time 'C'*/
            }
        }
    }

    /**
     * To this if we will input an already sorted array,to the function
     * bubble sort then this particular loop will execute only once to
     * figure once to figure out that it's already sorted.
     * So, in the Best case , the time taken will be c*(n-1) only.
     * Best case : O(n)
     * Average case : O(n^2)
     * Worst case : O(n^2)
     *
     * @param A
     */
    static void bubbleSortImprovement(int[] A) {
        int n = A.length;
        int flag = 0;
        //After n-1 pass we guarantee to be sorted
        for (int k = 1; k <= n - 1; k++) { //this will run n-1 times
            for (int i = 0; i <= n - 2; i++) {//this will run n-1 times
                /* start*/
                flag = 0;
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    flag = 1;
                }
                /* End say it will take some constant time 'C'*/
            }
            if (flag == 0) break;
        }
    }
}
