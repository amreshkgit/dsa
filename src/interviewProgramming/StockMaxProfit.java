package interviewProgramming;

/**
 * Video link - https://www.youtube.com/watch?v=TxZ_PN7OzOM to understand the concept
 */
public class StockMaxProfit {
    // Case first : buy once sell once
    public void MaxProfitBuySellOnce(int stockPrices[]) {
        int minStockPrice = stockPrices[0];
        int maxStockPrice = stockPrices[0];
        int buy = 0, sell = 0, profit = 0, difference = 0;

        for (int i = 1; i < stockPrices.length; i++) {
            if (minStockPrice > stockPrices[i]) {
                difference = maxStockPrice - minStockPrice;
                if (difference > profit) {
                    buy = minStockPrice;
                    sell = maxStockPrice;
                    profit = difference;
                }
                minStockPrice = stockPrices[i];
                maxStockPrice = stockPrices[i];
            } else if (maxStockPrice < stockPrices[i]) {
                maxStockPrice = stockPrices[i];
            }
        }
        difference = maxStockPrice - minStockPrice;
        if (difference > profit) {
            buy = minStockPrice;
            sell = maxStockPrice;
            profit = difference;
        }
        System.out.println("Max Profit : " + profit + " when we buy at : "
                + buy + " and sell at : " + sell);
    }

    // Case Second : buy & sell multiple times
    public void MaxProfitBuySellMulti(int stockPrices[]) {
        int minStockPrice = stockPrices[0];
        int maxStockPrice = stockPrices[0];
        int profit = 0, difference = 0;

        for (int i = 1; i < stockPrices.length; i++) {
            if (minStockPrice > stockPrices[i]) {
                difference = maxStockPrice - minStockPrice;
                profit = profit + difference;
                minStockPrice = stockPrices[i];
                maxStockPrice = stockPrices[i];
            } else if (maxStockPrice < stockPrices[i]) {
                maxStockPrice = stockPrices[i];
            }
        }
        difference = maxStockPrice - minStockPrice;
        profit = profit + difference;
        System.out.println("Max Profit when buy and sell multi : " + profit);
    }

    //Buy and sell once
    // Approach - we will sell it everyday and we will see the what was the min price before that
    //Suppose i am selling it today then min price before this, if i had purchased at that then i would
    //have got max profit
    public static int maxProfit(int[] stockPrice){
        int maxProfit=0;
        int minSoFar=stockPrice[0];
        for(int i=0; i<stockPrice.length;i++){
            minSoFar = Math.min(minSoFar,stockPrice[i]);
            int profit = stockPrice[i]-minSoFar;
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }

    //Any number of stock we can buy and sell, every buy we need to sell, and we can't buy continuously 2 times that
    // means at a time you should have only 1 stock
    public static int maxProfit2(int[] stockPrice){
        int profit=0;
        for(int i=1; i<stockPrice.length;i++){
           if(stockPrice[i] > stockPrice[i-1]){
               profit += stockPrice[i] - stockPrice[i-1];
           }
        }
        return profit;
    }

    public static void main(String arrr[]) {
        int stockPrices[] = { 100, 120, 150, 200, 80, 50, 110, 150, 200, 210 };
        int stockPrices1[] = { 5, 2, 6, 1, 4};
        StockMaxProfit maxProfit = new StockMaxProfit();
        maxProfit.MaxProfitBuySellOnce(stockPrices);
        maxProfit.MaxProfitBuySellMulti(stockPrices);
        System.out.println(maxProfit(stockPrices1));
    }


}
