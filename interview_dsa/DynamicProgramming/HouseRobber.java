package DynamicProgramming;


/**
 * Brute force and greedy will not work
 * becuase in brute force we have oto try with all the combination
 * greedy will not work certain test case but not for all because say 6,9,6 here as per greedy 9 will the ans
 * however actual ans is 12 (6+6)
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[]nums={2,7,3,1,4,2,1,8};
        System.out.println(robFurtherOptimize(nums));
    }

    //Time complexity - O(n) because we iterating aray once
    //space comp will be O(n) because to store the memozation result.
    // Formula
    // house ...(n-3) (n-2) (n-1) n
    // Total loot if robbed (n-2) = total_loot[n-2]+loot[n] // we choose rob to nth house
    // Total loot if i am not robbing last house i.e. nth house = total_loot[n-1]
    // Therefore Total loot at house(n) = Max(total_loot[n-2]+loot[n],total_loot[n-1])
    public static int rob(int[] nums){
        //if only one element , just return it
        if(nums.length <2){
            return nums[0];
        }
        //creatae array to store the maximum loot at each index
        int[]dp = new int[nums.length];

        //Memoize maximum loot at first 2 indexes
        dp[0] =nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        //use them fill complete array
        for(int i=2; i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    public static int robFurtherOptimize(int[] nums){
        int len = nums.length;
        if(len == 1)
            return nums[0];
        nums[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < len; i++)
        {
            nums[i] = Math.max(nums[i - 2] + nums[i],nums[i - 1]);
        }
        return nums[len - 1];
    }
}
