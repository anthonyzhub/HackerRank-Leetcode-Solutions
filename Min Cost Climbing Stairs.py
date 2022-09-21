# https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution:
    
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        
        # If list is empty, return 0
        if len(cost) == 0:
            return 0
        
        # Get size of list
        size = len(cost)
        
        # Traverse list
        for i in range(2, size):
            
            # Update ith element by adding i-1 or i-2 element. Whichever is least expensive
            cost[i] += min(cost[i - 1], cost[i - 2])
            
        # Return minimum total cost
        return min(cost[size - 1], cost[size - 2])
