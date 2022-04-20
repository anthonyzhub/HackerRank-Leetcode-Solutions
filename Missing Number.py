# https://leetcode.com/problems/missing-number/

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        
        # Sort list
        nums.sort()
        
        # Traverse list
        for i in range(len(nums)):
            
            # If i doesn't appear in nums, then return missing digit
            if i != nums[i]:
                return i
            
        # If function is still continuing, then missing digit is the last
        # E.g., [0, 1] has a length of 2, but 2 is not inside the list. Therefore, it is the missing digit.
        return len(nums)
