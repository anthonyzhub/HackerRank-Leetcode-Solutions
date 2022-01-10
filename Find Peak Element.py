# https://leetcode.com/problems/find-peak-element/

import sys
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        # If list is empty, exit function
        if nums is None:
            return
        
        # If list only has 1 element, return it
        if len(nums) <= 2:
            return nums.index(max(nums))
        
        # Create a list to keep track of value and element
        peakElem = [nums[0], 0]
        
        # Iterate list
        for idx in range(1, len(nums) - 1):
            
            # Get current element
            currElem = nums[idx]
        
            # Inspect neighbors
            if nums[idx - 1] < currElem and currElem > nums[idx + 1]:
                
                # Compare potential peak element with saved peak element
                if currElem >= peakElem[0]:
                    
                    # Update peakElem
                    peakElem = [currElem, idx]
                    
        # Do one more comparison with last element
        lastElem = nums[-1]
        penElem = nums[-2]
        
        if lastElem > penElem and lastElem > peakElem[0]:
            peakElem = [lastElem, len(nums) - 1]
        
        # Return saved index
        return peakElem[1]
