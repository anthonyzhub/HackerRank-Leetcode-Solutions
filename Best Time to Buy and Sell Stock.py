# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

import sys

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        # If list only has 1 element, return 0
        if len(prices) == 1:
            return 0
        
        # Iterate list
        maxProfit = 0
        minPrice = sys.maxsize # <= Get highest possible number
        for idx in range(len(prices)):
            
            # Update variable for smallest price
            if prices[idx] < minPrice:
                minPrice = prices[idx]
            
            # Check if current profit margin can beat max profit
            elif prices[idx] - minPrice > maxProfit:
                maxProfit = prices[idx] - minPrice
            
        return maxProfit
