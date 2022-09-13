# https://leetcode.com/problems/combination-sum-iii/

class Solution:
    
    def comboMaker(self, maxLen, target, curNum, curSum, curCombo, res):
        
        # OBJECTIVE: Create a list of combinations where each combo doesn't exceed length of maxLen and curSum isn't greater than target
        
        # If combo's sum equals to target and its length equals to maxLen, save curCombo in res
        if curSum == target and len(curCombo) == maxLen:
            
            # Transfer elements from curCombo to res
            res.append(curCombo[:])
            return
        
        # If current number is greater than or equal to 10 and curSum is greater than target, exit function
        # I.e., This is an invalid combination, so exit function
        if curNum + 1 >= 10 or curSum > target:
            return
        
        # Add new number to curCombo
        curCombo.append(curNum + 1)
        
        # Make a recursive call
        self.comboMaker(maxLen, target, curNum + 1, curSum + curNum + 1, curCombo, res)
        
        # Remove recently added number from curCombo
        curCombo.pop()
        
        # Make another recursive call[]
        self.comboMaker(maxLen, target, curNum + 1, curSum, curCombo, res)
    
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        
        # Create 2 lists - 1 for output and another to hold working combinations
        res = list()
        curCombo = list()
        
        # Create a list of combinations
        self.comboMaker(k, n, 0, 0, curCombo, res)
        
        # Return output
        return res
        
