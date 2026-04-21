package DynamicProgramming;

public class KnapsackRecursive {
    public static void main(String[] args) {
        int [] profit ={60,100,120};
        int [] weight ={10,20,30};
        int capacity =50; //knapsack capacity

        int answer = knapsack(weight,profit,capacity,3);
        System.out.println("Total knapsack profit ---> :: "+answer);
    }

    public static int knapsack(int[] weight,int [] profit,int capacity,int arraySize){
        //For this input what could be the answer definitely will be zero
        //Base condition
        if(arraySize == 0 || capacity == 0 )
            return 0;
        //here arraySize-1 means starting from last element
        if(weight[arraySize-1] <= capacity){ //when weight of the item is less then capacity
            return Math.max(profit[arraySize-1] +
                    knapsack(weight, profit, capacity-weight[arraySize-1], arraySize-1),
                    knapsack(weight, profit, capacity, arraySize-1));
            //This return statement says get the maximum value from both the choices after including or not including
        }else //when weight of the item is greater then capacity
            return knapsack(weight, profit, capacity, arraySize-1);
    }
}
//profit[arraySize-1] //This line to include the get the profit
// + knapsack(weight, profit, capacity-weight[arraySize-1], arraySize-1 -- This line means to choose from remaining element
//knapsack(weight, profit, capacity, arraySize) -- This means not to include the item and again call the knapsack on remaining
//element