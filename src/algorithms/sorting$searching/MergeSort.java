package algorithms.sorting$searching;

import java.util.stream.IntStream;

/**
 * T(n) = 2T(n/2) + O(n)
 * Complexity O(nlogn)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] A = {2, 4, 1, 6, 8, 5, 3};
        mergeSort(A);
        IntStream.of(A).boxed().forEach(x -> System.out.print(x + " "));
    }

    static void mergeSort(int[] A) {
        int n = A.length;

        if (n < 2) return;

        //find the mid element
        int mid = n / 2;

        /* Create temp arrays */
        int[] left  = new int[mid];
        int[] right = new int[n - mid];

        /*Copy data to temp arrays*/
        for (int i = 0; i <= mid - 1; i++)
            left[i] = A[i];

        /*Copy data to temp arrays*/
        for (int j = mid; j <= n - 1; j++)
            right[j-mid] = A[j];

        mergeSort(left);
        mergeSort(right);
        merge(left, right, A);
    }

    static void merge(int[] left, int[] right, int[] A) {
        int nL = left.length;//left array length
        int nR = right.length; // right array length

        //(i) is for left half array , (j) is for right half of the array and (k) marked the position to filled in A
        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR) {
            //comparing the smallest unpicked in Left and smallest unpicked in right
            if (left[i] <= right[j]) {
                //In Kth Position in A we will write left[i] remember we are overriding value in A
                A[k] = left[i];
                //this is for to go to next unpicked element in left
                i++;
            } else {
                A[k] = right[j];
                //this is for to go to next unpicked element in right
                j++;
            }
            k++;
        }
        //This is probability that one of the array left or right will exhaust first. In that case we need to
        //pick all the elements of the other array and fill rest of the position in A.
        /* Copy remaining elements of left[] if any */
        while (i < nL) {
            A[k] = left[i];
            i++;
            k++;
        }
        /* Copy remaining elements of right[] if any */
        while (j < nR) {
            A[k] = right[j];
            j++;
            k++;
        }
    }

}
