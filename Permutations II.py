# Link: https://leetcode.com/problems/permutations-ii/submissions/

from itertools import permutations

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        # If nums only has one element, return itself
        if len(nums) == 1:
            return [nums]
        
        # Create a set
        permutationSet = set()
        
        # Iterate all possible permutations
        for i in permutations(nums, len(nums)):
            
            # Add all possibilities to the set.
            # NOTE: set() does not add duplicates
            permutationSet.add(i)
            
        return permutationSet
