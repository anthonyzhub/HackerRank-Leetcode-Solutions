/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
https://youtu.be/3SJ3pUkPQMc?si=j0LGPamJPD_cMKWm

Time Complexity: O(n) where n = length of array

Space Complexity: O(1)
*/

class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
