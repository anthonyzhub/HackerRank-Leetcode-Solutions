# https://leetcode.com/problems/subsets-ii/

class Solution:
    
    def search(self, path, nums, ans):
        
        # Add path to ans
        ans.append(path)
        
        # Iterate list
        for i in range(len(nums)):
            
            # NOTE: Only need one unique digit to start branching
            if i > 0 and nums[i] == nums[i-1]:
                continue
                
            # Create a new branch with new digit
            self.search(path + [nums[i]], nums[i+1:], ans)
    
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        
        # If nums only has 1 element, return it
        if len(nums) == 1:
            return [[], nums]
        
        # Create a list to store answers
        ans = []
        
        # Break down list as a tree
        self.search([], sorted(nums), ans)
        
        return ans
