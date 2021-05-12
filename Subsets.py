# Link: https://leetcode.com/problems/subsets/submissions/

from itertools import combinations

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        # If nums is empty, exit function
        if len(nums) == 1:
            return [[], nums]
        
        # Create a list to store answers
        ans = list()
        
        # Create all possible combinations based on nums' size
        for size in range(len(nums)):
            
            # Turn every combination to a list. Default output is a tuple.
            for combo in map(list, combinations(nums, size)):
                ans.append(combo)
        
        # Add nums to ans
        ans.append(nums)
        
        return ans
