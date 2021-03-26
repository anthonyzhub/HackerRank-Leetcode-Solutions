# Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/

class Solution:
    
    def iterateList(self, nums, target, reverseOrder):
        
        if reverseOrder == False:
            
            for idx, i in enumerate(nums):
                if i == target:
                    return idx
        else:
            
            for idx, i in enumerate(reversed(nums)):
                if i == target:
                    return len(nums) - 1 - idx

        return -1
    
    def mySearchRange(self, nums: List[int], target: int) -> List[int]:
        
        # If nums is empty, exit function
        if len(nums) == 0 or nums == None:
            return [-1, -1]
        
        # If target is not in nums, exit function
        if target not in nums:
            return [-1, -1]
        
        # Get index of first occurrence
        firstIdx = self.iterateList(nums, target, False)
        
        # Get index of last occurrence
        lastIdx = self.iterateList(nums, target, True)
        
        # Check if target only occurred once
        if lastIdx == -1:
            return [-1, -1]
        
        return [firstIdx, lastIdx]
