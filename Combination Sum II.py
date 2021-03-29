# Link: https://leetcode.com/problems/combination-sum-ii/submissions/

from copy import deepcopy

class Solution:
    
    def makeCombination(self, candidates, target, idx, currPossibleCombination, ans):
        
        # If target is negative, exit function
        if target < 0:
            return
        
        # If target equals to 0, make a copy of combination and add it to ans
        if target == 0:
            ans.append(deepcopy(currPossibleCombination))
            return
        
        # Iterate starting with next element
        for i in range(idx, len(candidates)):
            
            # Check if we're at the same position.
            # Also check if current number doesn't match previous number
            if i == idx or candidates[i] != candidates[i - 1]: # <= This prevents adding duplicates
                
                # Add new element to list of possible combinations
                currPossibleCombination.append(candidates[i])

                # Make a recursive call with a new list, target, and index
                self.makeCombination(candidates, target - candidates[i], i + 1, currPossibleCombination, ans)

                # Remove recently added element and look for a new one
                currPossibleCombination.pop(-1)
    
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        
        # If either variables are NoneType, exit function
        if candidates == None or target == None:
            return []
        
        # Sort list
        candidates.sort()
        
        # Make all possible combinations
        ans = list()
        self.makeCombination(candidates, target, 0, [], ans)
        return ans
