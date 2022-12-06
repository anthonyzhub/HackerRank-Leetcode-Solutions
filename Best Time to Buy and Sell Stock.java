// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        
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
