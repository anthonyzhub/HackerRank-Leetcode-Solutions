# https://leetcode.com/problems/contains-duplicate/description/

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:

        """
        OBJECTIVE: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

        Time Complexity: O(n) where n = length of nums. set() will iterate nums and save each unique element to itself

        Space Complexity: O(k) where k = number of unique elements inside nums. Worst case scenario is having only unique
        elements inside of nums. If that happens, all elements will be saved in numsSet.
        """

        # Turn list to a set
        numsSet = set(nums)
        
        # If set and list doesn't share same size, then return true because nums contains duplicates
        if len(numsSet) != len(nums):
            return True
        
        return False
