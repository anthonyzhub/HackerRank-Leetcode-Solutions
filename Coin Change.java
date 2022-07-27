// https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // If amount is 0 and coins list isn't empty, return 0
        if (amount == 0 && coins.length > 0) {return 0;}
        
        // Check if amount already exist as a coin in coins array
        for (int coin: coins) {
            if (coin == amount) {return 1;}
        }
        
        // Create a dp array
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        // Set 1st element as 0.
        // NOTE: You need 0 coins to reach 0 amount
        dp[0] = 0;
        
        // Find out how many coins are needed to reach i-value
        for (int i=1; i<amount+1; i++) {
            
            // Iterate coins list
            for (int coin: coins) {
                
                // If coin is greater than or equal to i-value, update the ith index in dp
                if (i - coin >= 0) {
                    
                    // Keep the minimum number of coins needed to reach i-value
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If element doesn't equal to its original maximum value, return its new minimum value
        if (dp[amount] != amount + 1) {
            return dp[amount];
        }
        
        return -1;
    }
}
