# Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
# NOTE: Method used is breadth first search

class Solution:
    
    def bfsCombo(self, digitsToAlpha, digits, currCombo, currIndex, ans):
        
        # Exit if length of combination equals length of digits
        if currIndex == len(digits):
            
            # Save combination to list and exit function
            ans.append(currCombo)
            return
        
        # Get string of current key
        currVal = digitsToAlpha[digits[currIndex]]
        # print("currVal: {}".format(currVal))
        # print("currCombo: {}".format(currCombo))
        
        # Iterate string (value inside dictionary)
        for i in range(len(currVal)):
            
            # Get current letter from string (value inside dictionary)
            currLetter = currVal[i]
            
            # Make a recursive call
            self.bfsCombo(digitsToAlpha, digits, currCombo + currLetter, currIndex + 1, ans)
    
    def letterCombinations(self, digits: str) -> List[str]:
        
        # Create a dictionary
        digitsToAlpha = {"2": "abc",
                        "3": "def",
                        "4": "ghi",
                        "5": "jkl",
                        "6": "mno",
                        "7": "pqrs",
                        "8": "tuv",
                        "9": "wxyz"}
        
        # Return empty list, if digits is empty
        if digits == "":
            return []
        
        # Return key's value, if digits is 1 character long
        if len(digits) == 1:
            return list(digitsToAlpha[digits])
        
        # Create list to hold all combinations
        ans = list()
        
        # Get list of combinations
        self.bfsCombo(digitsToAlpha, digits, "", 0, ans) # <= list is passed as reference
        return ans
