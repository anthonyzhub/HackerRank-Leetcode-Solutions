# https://leetcode.com/problems/product-of-array-except-self/

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        """
        OBJECTIVE: Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        Time Complexity: O(n) where n = length of nums. 2 for-loops were created to iterate the nums. Each loop's runtime is O(n)

        Space Complexity: O(n) where n = length of res. A return array had to be created and its size is based off nums' size
        """

        # Get length of nums
        n = len(nums)

        # Create a return list filled with 1's
        res = [1] * n

        # Calculate prefix and update res
        # NOTE: This multiples all the numbers before the ith number
        prefix = 1
        for i in range(n):
            res[i] = prefix
            prefix *= nums[i]
        
        # Calculate postfix and update res
        # NOTE: This multiples all the numbers after the ith number
        postfix = 1
        for i in range(n - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]

        return res
