# Link: https://leetcode.com/problems/permutations/submissions/

from itertools import permutations

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        # If nums only has one element, return itself
        if len(nums) == 1:
            return [nums]
        
        # Calculate all possible permutations
        """
        1. permutations() stores all possibilities as a tuple
        2. Use map() to turn each tuple into a list
        3. Afterwards, store all possibilities into one list
        """
        permutationsList = list(map(list, permutations(nums, len(nums))))
        
        return permutationsList
