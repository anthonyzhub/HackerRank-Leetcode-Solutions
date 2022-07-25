# https://leetcode.com/problems/majority-element-ii/

from collections import Counter

class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
                
        # Turn list to a dictionary
        nums = Counter(nums)
        
        # Iterate dictionary and save keys with matching maxVal
        res = list()
        for k, v in nums.items():
            
            # If value is greater than n/3, add it to list
            if v > (len(nums) / 3):
                res.append(k)
                
        return res
