package interviewProgramming;

import java.util.Arrays;

public class FindATripletTheSumToAGivenValue {
    public static void main(String[] args) {
        int[] a = {12, 3, 4, 1, 6, 9};
        int sum = 24;
        findTriplet(a,a.length,sum);
    }

    static boolean findTriplet(int[] a, int arr_size, int sum) {
        int l, r;
        Arrays.sort(a);
        for (int i = 0; i < arr_size - 2; i++) {
            l = i + 1;
            r = arr_size - 1;
            while (l < r) {
                if (a[i] + a[l] + a[r] == sum) {
                    System.out.print("Triplet is " + a[i] + ", " + a[l] + ", " + a[r]);
                    return true;
                } else if (a[i] + a[l] + a[r] < sum)
                    l++;

                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }
        return false;
    }
}
