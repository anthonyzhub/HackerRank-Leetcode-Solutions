// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {

    public int mySolution(int[] prices) {

        /*
         * SIDE NOTE: This is the solution that I came up with :)
         * IMPORTANT: It really helps to create a graph and understand it from a non-programming perspective.
         *  Do what you normally do when trading stocks, buy low and sell high :)
         * 
         * Time Complexity: O(n) where n = length of input list. The list iterated once
         * 
         * Space Complexity: O(1) because no additional dynamic data structure was created
         */

        // If there's only 1 price inside list, then you can't make a profit
        if (prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;

        // Set 1st price as buying price and iterate list
        int buyingPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {

            // Set ith element as selling price
            int sellingPrice = prices[i];
            
            // If sellingPrice - buyingPrice >= 0, update maxProfit
            // If not, then update buyingPrice to the newest smallest price
            if (buyingPrice <= sellingPrice) {
                maxProfit = Math.max(maxProfit, sellingPrice - buyingPrice);
            }
            else {
                buyingPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public int solution1(int[] prices) {
        
        int smallestPrice = Integer.MAX_VALUE;
        int highestProfit = 0;
        int todaysProfit = 0;

        // Iterate array
        for (int i = 0; i < prices.length; i++) {
            
            // Update smallestPrice
            if (prices[i] < smallestPrice) {
                smallestPrice = prices[i];
            }

            // Calculate todaysProfit
            todaysProfit = prices[i] - smallestPrice;

            // If highestProfit is smaller than todaysProfit, update variable
            if (highestProfit < todaysProfit) {
                highestProfit = todaysProfit;
            }
        }

        return highestProfit;
    }

    public int solution2(int[] prices) {
        
        /*
        OBJECTIVE: You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
        
        Time Complexity: O(n) where n = length of prices. A while-loop was created to iterate the loop once
        
        Space Complexity: O(1) because no additional space was used
        */
        
        // Get length of array
        int n = prices.length;
        
        // Create 2 pointers
        int leftPtr = 0;
        int rightPtr = 1;
        
        // Create a variable to hold max profit
        int maxProfit = 0;
        
        // Iterate list
        while (rightPtr < n) {
            
            if (prices[leftPtr] < prices[rightPtr]) {
                maxProfit = Math.max(maxProfit, prices[rightPtr] - prices[leftPtr]);
                rightPtr++;
            }
            else {
                leftPtr = rightPtr;
                rightPtr++;
            }
        }
        
        return maxProfit;
    }
}
