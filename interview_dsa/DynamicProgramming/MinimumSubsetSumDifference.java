package DynamicProgramming;

/**
 * Minimum sum difference between subset so,
 * for example subset can be {1,6,5} {11} = 12-11 = 1
 * {6,5} {1,11} = 12-11 = 1
 */
public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
     int[] arr= {1,6,5,11};
        System.out.println(MinimumSubsetSumDifference.minSumDiff(arr));
    }

    //Time Complexity = O(n*sum) where n is the number of elements and sum is the sum of all elements.
    public static int minSumDiff(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            int first = i;
            int second = sum - i;
            if (dp[n][i] && diff > Math.abs(first - second)) {
                diff = Math.abs(first - second);
            }
        }
        return diff;
    }

}

