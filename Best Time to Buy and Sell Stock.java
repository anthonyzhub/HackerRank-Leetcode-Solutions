// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {

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
