# https://leetcode.com/problems/valid-mountain-array/

class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        
        # If arr's length is less than 3, return false
        if len(arr) < 3:
            return False
        
        # Create a pointer and get size of list
        peak = 0
        arrSize = len(arr)
        
        # Traverse array from left-to-right
        # I.e., Walk up the mountain
        while peak + 1 < arrSize and arr[peak] < arr[peak + 1]:
            peak += 1
        
        # If peak element is either the first or last element, return false
        # E.g., 0 1 2 3 4 or 4 3 2 1
        if peak == 0 or peak == len(arr) - 1:
            return False
        
        # Traverse array from right-to-left
        # I.e., Walk down the mountain
        while peak + 1 < arrSize and arr[peak] > arr[peak + 1]:
            peak += 1
        
        # If pointer reached the end of the list (climbed down the mountain), return true
        return peak == len(arr) - 1
