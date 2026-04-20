package DynamicProgramming;

public class CountTheNumberOfSubsetWithGivenDifference {
    public static void main(String[] args) {
        int diff =1;
        int [] arr ={1,1,2,3};
        int sum = diff+(1+1+2+3)/2;
        System.out.println(sum);
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
