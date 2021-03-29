# Link: https://leetcode.com/problems/combination-sum/submissions/

from copy import deepcopy

class Solution:
    
    def makeCombination(self, candidates, idx, target, currPossibleCombination, ans):
        
        # If target is less than 0, exit function
        if target < 0:
            return
        
        # If currSum has reached target, exit function
        if target == 0:
            ans.append(deepcopy(currPossibleCombination)) # <= Made a deepcopy because without it, only reference would be added
        
        # Iterate remaining part of the list and make a recursive call
        for i in range(idx, len(candidates)):
            
            # Add current number to possible combination
            currPossibleCombination.append(candidates[i])
            
            # Make a recursive call with a new list
            self.makeCombination(candidates, i, target - candidates[i], currPossibleCombination, ans)
            
            # After coming back from recursive call, pop recently added element and try a new number
            currPossibleCombination.pop(-1)
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        # If either variables are NoneType, return an empty list
        if candidates == None or target == None:
            return []
        
        # If canadidates only has 1 element and target is that element, return it
        if len(candidates) == 1 and target in candidates:
            return [candidates]
        
        # Sort array
        candidates.sort()
        
        # Call makeCombination() to find out all possible combinations to add up to target
        ans = list()
        self.makeCombination(candidates, 0, target, [], ans)
        return ans
