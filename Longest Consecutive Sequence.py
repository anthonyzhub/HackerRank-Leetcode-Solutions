# https://leetcode.com/problems/longest-consecutive-sequence/

import sys

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        
        # If list is empty, return 0
        if len(nums) == 0:
            return 0
        
        # If list only has 1 element, return 1
        if len(nums) == 1:
            return 1
        
        # Add largest number at the end of the list
        maxNum = sys.maxsize
        nums.append(maxNum)
        
        # Sort list
        nums.sort()
        
        # Create sequence variables
        # NOTE: Count 1st digit as start of the sequence, so its 1
        longestSeq = 0
        tmpSeq = 1
        
        # Iterate list
        for idx in range(1, len(nums)):
            
            # If next digit is maxNum, then we have reached the end of the list
            if nums[idx] == maxNum:
                break
            
            # If difference between this and previous digit is greater than 1, then update longestSeq and reset counter
            if nums[idx] - nums[idx - 1] > 1:
                longestSeq = max(longestSeq, tmpSeq)
                tmpSeq = 1
                
            # If this and previous number are the same, don't increment sequence counter
            elif nums[idx] - nums[idx - 1] == 0:
                continue
            
            else:
                tmpSeq += 1
                
        # Recalculate max value in case sequence ended when maxNum was encountered
        return max(longestSeq, tmpSeq)
