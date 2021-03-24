# Link: https://leetcode.com/problems/generate-parentheses/submissions/

class Solution:
    
    def combination(self, n, numOfOpen, numOfClose, currStr, ans):
        
        # If open and close parentheses are equal, add string to list and exit function
        if numOfOpen == numOfClose == n:
            return ans.append(currStr)
        
        # If another open parentheses can be added, add it
        if numOfOpen < n:
            currStr += "("
            self.combination(n, numOfOpen + 1, numOfClose, currStr, ans) # <= Make another call with new string
            currStr = currStr[:-1] # <= Remove "(" and check if ")" can be added
            
        # Add another ")"
        if numOfOpen > numOfClose:
            currStr += ")"
            self.combination(n, numOfOpen, numOfClose + 1, currStr, ans)
            currStr = currStr[:-1]
            
        # Return list
        return ans
    
    def generateParenthesis(self, n: int) -> List[str]:
        
        # If n is 0, return an empty string
        if n == 0:
            return ""
        
        # If n is 1, return a single pair
        if n == 1:
            return ["()"]
        
        # Create list to hold all legal combinations
        ans = list()
        
        # Generate parentheses
        return self.combination(n, 0, 0, "", ans)
