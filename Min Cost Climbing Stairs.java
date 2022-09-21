// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        // If array is empty, exit function
        if (cost.length == 0) {return 0;}
        
        // Get size of array
        int size = cost.length;
        
        // Traverse array
        for (int i=2; i<size; i++) {
            
            // Update ith element by adding i-1 or i-2 element. Whichever is least expensive
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        
        // Return minimum total cost
        return Math.min(cost[size - 1], cost[size - 2]);
    }
}
