# https://leetcode.com/problems/house-robber/

class Solution:
    
    def dp(self, nums, idx, memo):
        
        # Return 0 to stop going out of bounds
        if idx < 0:
            return 0
        
        # If index was previously visited, return its potential robbery
        if idx in memo.keys():
            return memo[idx]
        
        # Return max value and save it to index
        result = max(self.dp(nums, idx - 2, memo) + nums[idx], self.dp(nums, idx - 1, memo))
        memo[idx] = result
        
        return result
    
    def rob(self, nums: List[int]) -> int:
        
        # If nums only has 2 or less elements, return max value
        # NOTE: If length is 1, max() will only return 1 element
        if len(nums) <= 2:
            return max(nums)
        
        # Create a dictionary for memoization
        memo = dict()
        
        # Use dynamic programming to solve problem
        return self.dp(nums, len(nums) - 1, memo)
