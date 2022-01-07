# https://leetcode.com/problems/random-pick-index/

from random import choice
class Solution:

    def __init__(self, nums: List[int]):
        
        # Save parameter
        self.nums = nums
        
    def pick(self, target: int) -> int:
        
        # Create a temporary list to hold indexes holding "target" value
        indexList = list()
        
        # Iterate nums
        for idx in range(len(self.nums)):
            
            # Save index in other list
            if self.nums[idx] == target:
                indexList.append(idx)
                
        # Return a random element from list
        return choice(indexList)
        
# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
