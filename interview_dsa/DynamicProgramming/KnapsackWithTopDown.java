package DynamicProgramming;

public class KnapsackWithTopDown {


    public static void main(String[] args) {
        Integer[][] T  = new Integer[5][8]; // [item+1] [capacity+1] +1 isliye kyun ki item lenge to it will go item -1
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        //int capacity =7; //knapsack capacity
        int maxProfit = knapsack(T,weights,profits,7,weights.length);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = knapsack(T,weights,profits,6,weights.length);
        System.out.println("Total knapsack profit ---> " + maxProfit);

    }

    public static int knapsack(Integer[][] dp,int[] weight,int[] value,int capacity,int size){
        if(size == 0 || capacity == 0 )
            return 0;

        if(dp[size][capacity] != null)
            return dp[size][capacity];

        if(weight[size-1] > capacity)
            return dp[size][capacity] = knapsack(dp,weight,value,capacity,size-1);
        else
        return dp[size][capacity] = Math.max(value[size-1] + knapsack(dp,weight,value,capacity-weight[size-1],size-1),
                knapsack(dp,weight,value,capacity,size-1));
    }
}