# https://leetcode.com/problems/increasing-triplet-subsequence

import sys

class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        
        """
        OBJECTIVE: Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
        
        Time Complexity: O(n) where n = length of nums. List is being iterated to find an appropriate list of indices
        
        Space Complexity: O(1) because no additional space was taken
        """
        
        # If list's length is less than 3, exit function
        if len(nums) < 3:
            return False
        
        # Create 2 pointers
        leftPtr = sys.maxsize
        rightPtr = sys.maxsize
        
        # Iterate nums and locate midPtr
        # I.e., Update left and right pointers to existing element inside list. Also, stop iteration when iterator reaches a point 
        #       where it's between the left and right pointers
        for midPtr in nums:
            
            # If midPtr is less than or equal to leftPtr, update leftPtr
            if midPtr <= leftPtr:
                leftPtr = midPtr
            
            # If midPtr is less than or equal to rightPtr, update rightPtr
            elif midPtr <= rightPtr:
                rightPtr = midPtr
            
            # If leftPtr < midPtr < rightPtr, then return true
            else:
                return True
                    
        
        # If function is still continuing, then return false
        return False
