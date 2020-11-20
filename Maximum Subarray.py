# Link: https://leetcode.com/problems/maximum-subarray/submissions/

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        # Base case: If list only has 1 element, return that element
        if len(nums) == 1:
            return nums[0]
        
        # Create two variables to hold future sum
        maxSum = nums[0]
        total = nums[0]
        
        # Iterate list (skip 1st element, since we already have it)
        for i in nums[1:]:
            
            # What's bigger? Current element or sum of previous elements including this one
            # NOTE: If i is bigger, then restarting counting
            total = max(i, total + i)
            
            # What's bigger? old maxSum or new total
            maxSum = max(maxSum, total)
            
        return maxSum
