package interviewProgramming;

public class RodCuttingProblem {

    public static void main(String[] args) {
        int[] rod = {30, 59, 110};
        long maximumProfit = calculateMaximumProfit(1, 10, rod);
        System.out.println("maximumProfit ::" + maximumProfit);
    }

    public static long calculateMaximumProfit(int cost_per_cut, int metal_price, int[] arr) {
        int max = arr[0];
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++)
            if (max < arr[i])
                max = arr[i];
        for (int size = 1; size <= max; size++) {
            int profit = 0;
            for (int i = 0; i < arr.length; i++) {
                if (size > arr[i])
                    continue;
                int currPrice = (arr[i] / size) * metal_price * size; // current Rod price after cutting it.
                int cuts = arr[i] % size == 0 ? (arr[i] / size) - 1 : (arr[i] / size); // Number of cuts depend on the length of rod.
                int currProfit = currPrice - cost_per_cut * cuts;
                if (currProfit > 0)
                    profit += currProfit;
            }
            if (profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
