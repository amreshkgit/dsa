package DynamicProgramming.UnboundedKnapsack;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int price[] = new int[] {2,5,7,8};
        int n = 5;
          int max = maxProfit(price,n);
          System.out.println(max);
    }

    public static int maxProfit(int [] price,int N){
        //For this input what could be the answer definitely will be zero
        //Base condition
        if(N == 0)
            return 0;

        return Math.max(price[N-1] + maxProfit(price, N-1),maxProfit(price, N-1));

    }
}
