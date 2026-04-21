package DynamicProgramming;

/**
 * Given a set of non-negative integers, and a value sum, determine
 * if there is a subset of the given set with sum equal to given sum.
 */
public class SubsetSumProblem {
    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean answer = isSubsetSum(set,set.length,sum);
        System.out.println("Answer : "+answer);
    }

    public static boolean hasSubset(int[]arr,int sum,int size){
        //Base Cases:
        //hasSubset(arr, sum, n) = true, if sum == 0
        //hasSubset(arr, sum, n) = false, if sum > 0 and n == 0
        if (sum == 0)
            return true;
        if (size == 0 && sum > 0)
            return false;

        if(arr[size-1] > sum){
            return hasSubset(arr,sum,size-1);
        }else {
            return   hasSubset(arr,sum-arr[size-1],size-1) || hasSubset(arr, sum, size-1);
            // hasSubset(arr, sum, size-1) -- not include the element
            //hasSubset(arr,sum-arr[size-1],size-1) -- include the element
        }
    }

    /**
     * Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
     * Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n. + O(n) for recursive stack space
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    static boolean isSubsetSum(int arr[],int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (arr[i - 1] > j) { // number at arr[i-1] is greater then sum
                    dp[i][j] = dp[i - 1][j]; //
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    //This says dp[i - 1][j - arr[i - 1]]; include the element
                    //dp[i - 1][j] this says not including the element
                }
            }
        }
        return dp[n][sum];
    }

}
