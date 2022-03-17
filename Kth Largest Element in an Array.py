# https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        # If nums only has 1 element, return it
        if len(nums) == 1:
            return nums[0]
        
        # Sort list
        nums.sort()
        
        # Return Kth LARGEST element
        return nums[len(nums) - k]
