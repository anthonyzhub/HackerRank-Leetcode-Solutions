# Link: https://leetcode.com/problems/count-and-say/submissions/

"""
1 <- Just one
11 <- There is one 1
21 <- There are two ones
1211 <- There is one 2 and one 1
111221 <- There is one 1, one 2, and 2 ones
"""

class Solution:
    def countAndSay(self, n: int) -> str:
        
        # If n is 1, return 1
        if n == 1:
            return "1"
        
        # Create variable to hold string
        currStr = "11"
        
        for i in range(n-2): # <= Subtracted 2 because loop would pass answer by 2
            
            # Create boolean variables for future use
            firstIteration = True
            
            # Set pre-defined variables
            oldNum = ""
            occurrences = 0
            output = ""
            
            # Iterate string
            for c in currStr:
                
                # If this is the first iteration, oldNum and occurrence needs to be set for the first digit
                if firstIteration == True:
                    
                    # Set variable to false
                    firstIteration = False
                    
                    # Update variables
                    occurrences = 1
                    oldNum = c

                elif c == oldNum:

                    # Increment occurrences if same digit appeared again
                    occurrences += 1

                else:

                    # If a new digit appeared, finalize counting of oldNum and update variables
                    
                    # Update output string
                    output += str(occurrences) + oldNum

                    # Update oldNum and occurrences
                    oldNum = c
                    occurrences = 1
                    
            # If inner for-loop ended and a character was still being counted, add last counter
            # Update output string
            output += str(occurrences) + oldNum
            
            # Update currStr to new output
            currStr = output
            
        return currStr
