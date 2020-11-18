# Link: https://leetcode.com/problems/two-sum/submissions/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        ansDict = dict()
        
        # Iterate list
        for pos, i in enumerate(nums):
            
            # Compute temporary result
            result = target - i
            
            # If complement exist inside dictionary, return key's value and current index
            if i in ansDict.keys():
                return [ansDict[i], pos]
            
            # Add difference and current index to dictionary as key and value, respectively
            ansDict[result] = pos
            
