# https://leetcode.com/problems/coin-change/

import sys

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        """
        OBJECTIVE: Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
        
        Time Complexity: O((amount + 1) * coins). The outer-loop iterates amount + 1 times and each iteration involves iterating the coins list
        
        Space Complexity: O(n) where n = length of dp. The dp list's size will always be equal to amount + 1 because that's how the list was initialized
        """
        
        # Create a dp list where it'll hold N elements and each element has a maximum value of max int
        dp = [sys.maxsize] * (amount + 1)
        
        # Set the 0th element to 0. This is saying, "to reach 0 amount (the index), we only need 0 coins (the value at index)"
        dp[0] = 0
        
        # Iterate amount range
        # NOTE: Added +1 because range() is non-inclusive [)
        for curAmount in range(1, amount + 1):
            
            # Iterate coins list
            for coin in coins:
                
                # If remaining change greater than or equal to 0, save how many coins were needed to reach this amount
                if curAmount - coin >= 0:
                    
                    # Which option has less coins? The one we already have saved or that with 1 additional coin
                    # NOTE: Remember that the initial value is maximum int
                    dp[curAmount] = min(dp[curAmount], 1 + dp[curAmount])
                    
        # If index at amount isn't still at initial value, return value at index
        if dp[amount] != sys.maxsize:
            return dp[amount]
        
        # If function is still continuing, then the amount cannot be reached with any combination of coins
        return -1
