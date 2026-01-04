package org.problems.SlidingWindow;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int max_Price = 0;

        for(int price: prices){

            if(price < minPrice){
                minPrice = price;
            } else {
                int profit = price - minPrice;
                max_Price = Math.max(max_Price, profit);
            }
        }
        return max_Price;
    }
}
