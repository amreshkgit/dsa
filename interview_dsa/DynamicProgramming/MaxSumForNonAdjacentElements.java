package DynamicProgramming;

public class MaxSumForNonAdjacentElements {
    /**
     * Fast DP solution.
     */
    public int maxSum(int arr[]) {
        int excl = 0;
        int incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(incl, excl + arr[i]);
            excl = temp;
        }
        return incl;
    }
    public static void main(String args[]) {
        MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
        int arr[] = { 2, 10, 13, 4, 2, 15, 10 };
        System.out.println(msn.maxSum(arr));

    }
}
