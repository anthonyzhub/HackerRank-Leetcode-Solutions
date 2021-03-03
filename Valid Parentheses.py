# Link: https://leetcode.com/problems/valid-parentheses/submissions/

class Solution:
    def isValid(self, s: str) -> bool:
        
        # Base case: Exit if string is empty
        if len(s) <= 1:
            return False
        
        # Create list for open and closing braces
        openedBraces = list()
        closedBraces = list()
        
        # Create dictionary of pair
        bracesDict = {
                    "{": "}",
                    "[": "]",
                    "(": ")"
        }
        
        # Turn string into list
        sList = list(s)
        
        # Iterate list
        for c in range(len(sList)):
            
            # Add open and close braces
            if sList[c] in "{([":
                openedBraces.append(sList[c])
            elif sList[c] in "}])":
                closedBraces.append(sList[c])
                
                # If a closed brace appeared first and openBrace is empty, return False
                if len(openedBraces) <= 0:
                    return False
            
                # Get last two elements
                lastOpened = openedBraces[-1]
                lastClosed = closedBraces[-1]
                
                # Check if new characters are a pair
                if lastClosed != bracesDict[lastOpened]:
                    return False
                
                # Remove last 2 elements
                openedBraces.pop(-1)
                closedBraces.pop(-1)
                
        # If there is still a character left in either list, return false
        if len(openedBraces) >= 1 or len(closedBraces) >= 1:
            return False
                
        return True
