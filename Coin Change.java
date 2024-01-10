// https://leetcode.com/problems/coin-change/

class Solution {

    public int coinChangeSub(int[] coins, int amount, int[] memo) {

        // If amount is less than 0, then exit because we used too many coins
        if (amount < 0) {return -1;}

        // If amount is 0, congratulations because we don't need anymore coins
        if (amount == 0) {return 0;}

        // If an optimal solution has already been calculated for "amount", then return it rather than recompute it.
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }

        // Iterate list of available coins for use
        int optimalSolution = Integer.MAX_VALUE;
        for (int coin: coins) {

            // Calculate the least amount of coins needed to reach "amount"
            int best_solution_for_coin = coinChangeSub(coins, amount - coin, memo);

            // If the least amount of coins is greater than 0 & is less than the previous' optimal solution, then update variable to our new optimal solution
            if (0 <= best_solution_for_coin && best_solution_for_coin < optimalSolution) {
                optimalSolution = best_solution_for_coin + 1;
            }
        }

        // If optimal solution is -1, then it's impossible to reach "amount" with our "coins"
        if (optimalSolution == Integer.MAX_VALUE) {
            memo[amount - 1] = -1;
        }
        else {
            memo[amount - 1] = optimalSolution;
        }

        return memo[amount - 1];
    }

    public int coinChange(int[] coins, int amount) {

        /*
         * Time Complexity: O(m * n) => O(m) where m = 1 to amount and n = # of coins. Because of recursion and memoization,
         * the runtime depends on m. There's a recursive call for coin in coins while amount doesn't equal or become less than 0. 
         * Memoization also helps to end a recursive call early.
         * 
         * Space Complexity: O(m * n) where m = 1 to amount and n = # of coins. Same reason as above. 
         * 
         * Reference: https://betterprogramming.pub/learn-dynamic-programming-the-coin-change-problem-22a104478f50 
         */

        if (amount < 0) {
            return -1;
        }
        else {
            return coinChangeSub(coins, amount, new int[amount + 1]);
        }
    }

    public int coinChange_solutionA(int[] coins, int amount) {
        
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
