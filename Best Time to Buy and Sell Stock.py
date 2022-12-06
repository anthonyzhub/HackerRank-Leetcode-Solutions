# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        """
        OBJECTIVE: You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
        
        Time Complexity: O(n) where n = length of prices. A while-loop was created to iterate the loop once
        
        Space Complexity: O(1) because no additional space was used
        """
        
        # Get length of list
        n = len(prices)
        
        # Create pointers
        leftPtr = 0
        rightPtr = 1
        
        # Create variable to hold max profit
        maxProfit = 0
        
        # Iterate list
        while rightPtr < n:
            
            # If selling price is higher than buying, then calculate max profit and update rightPtr
            if prices[leftPtr] < prices[rightPtr]:
                maxProfit = max(maxProfit, prices[rightPtr] - prices[leftPtr])
                rightPtr += 1
            
            # If selling price isn't higher than buying, then move leftPtr to rightPtr and update rightPtr
            else:
                leftPtr = rightPtr
                rightPtr += 1
                
        return maxProfit
