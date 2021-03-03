# Link: https://leetcode.com/problems/roman-to-integer/submissions/

class Solution:
    def romanToInt(self, s: str) -> int:
        
       # Roman dictionary
        romanDict = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        
        # Create placeholders
        prevNum = 0
        currNum = 0
        total = 0
        
        # Iterate string
        for i in range(len(s)):
            
            # Get roman value
            currNum = romanDict[s[i]]
            
            # Compare currNum to previous number
            if currNum > prevNum:
                total += currNum - (2*prevNum)
            else:
                total += currNum
                
            # Update prevNum
            prevNum = currNum
            
        # Return answer
        return total
