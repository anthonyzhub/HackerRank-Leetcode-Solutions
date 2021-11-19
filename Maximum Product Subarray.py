# https://leetcode.com/problems/maximum-product-subarray/

class Solution:
    
    def maxProduct(self, nums: List[int]) -> int:
        
        # If nums only has 1 element, return its value
        if len(nums) == 1:
            return nums[0]
        
        # Create a new list of nums in reverse order
        reversedNums = nums[::-1]
        
        # Iterate both lists
        for idx in range(1, len(nums)):
            
            # If previous element is a 0, multiply current index with 1. 
            # If not, multiply it with previous element
            nums[idx] *= nums[idx - 1] or 1
            reversedNums[idx] *= reversedNums[idx - 1] or 1
        
        return max(nums + reversedNums)
