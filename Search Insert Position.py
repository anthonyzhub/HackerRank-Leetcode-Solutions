# Link: https://leetcode.com/problems/search-insert-position/submissions/

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        
        # Check if target is inside nums
        if target in nums:
            return nums.index(target)
        
        # If target is greater than great element, return list's length + 1
        if target > nums[-1]:
            return len(nums)
        
        # If target is less than smallest element, return 0
        if target < nums[0]:
            return 0
        
        # Search for possible index
        for i in range(len(nums)):
            
            if nums[i] < target and target < nums[i+1]:
                return i + 1
