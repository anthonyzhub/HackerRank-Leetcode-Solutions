# https://leetcode.com/problems/wiggle-sort-ii/

class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # Get length of nums
        n = len(nums)
        
        # If list's length is equal to 1, exit function
        if n == 1:
            return
        
        # Sort list
        nums.sort()
        
        # Get length of list of odd index elements
        half = len(nums[::2])
        
        # Split list into smaller and larger half in reverse order
        leftHalf = nums[:half][::-1]
        rightHalf = nums[half:][::-1]
        
        # Put elements from the smaller half on even indexes. Put elements from the largest half on odd indexes
        nums[::2] = leftHalf
        nums[1::2] = rightHalf
