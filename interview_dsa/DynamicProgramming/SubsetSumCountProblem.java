package DynamicProgramming;

/**
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {2, 3, 1} and {3, 3}
 */
public class SubsetSumCountProblem {
    public static void main(String[] args) {
        int [] arr ={2,3,5,6,8,10};
        int sum =10;
        int[][] dp = new int[arr.length+1][sum+1];
        for(int i=0;i<=arr.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=sum;i++){
            dp[0][i] = 0;
        }

        int count = countOfSubsetSum(dp,arr,sum,arr.length);
        System.out.println("subset count :: "+count);
    }

    public static int countOfSubsetSum(int[][] dp, int[] arr,int sum,int size){
         if (sum == 0)
            return 1;
        if (size == 0 && sum != 0)
            return 0;

        if(arr[size-1] > sum){
            return dp[size][sum] = countOfSubsetSum(dp,arr,sum,size-1);
        }else {
            return  dp[size][sum] = countOfSubsetSum(dp,arr, sum, size-1) + countOfSubsetSum(dp,arr,sum-arr[size-1],size-1);
        }
    }
}
