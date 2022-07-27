# https://leetcode.com/problems/coin-change/

class Solution:
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        # If amount is 0 and coins list isn't empty, return -1
        if amount == 0 and len(coins) > 0:
            return 0
        
        # If amount is already in coins, return 1
        if amount in coins:
            return 1
        
        # Create a list for dynamic programming
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        
        # Find out how many coins are needed to reach "i"
        for i in range(1, amount + 1):
            
            # Iterate coins list
            for coin in coins:
                
                # If coin is greater than or equal to i-value, update the ith index in dp
                if i - coin >= 0:
                    
                    # Keep the minimum number of coins needed to reach i-value
                    dp[i] = min(dp[i], dp[i - coin] + 1)
        
        # If element doesn't equal to its original maximum value, return its new minimum value
        if dp[amount] != amount + 1:
            return dp[amount]
        
        return -1
