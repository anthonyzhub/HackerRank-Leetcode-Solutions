# https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        # Exit function if "prices" only has 1 element
        if len(prices) == 1:
            return 0
        
        totalProfit = 0
        for idx in range(1, len(prices)):
            
            if prices[idx] > prices[idx - 1]:
                totalProfit += prices[idx] - prices[idx - 1]
                
        return totalProfit
