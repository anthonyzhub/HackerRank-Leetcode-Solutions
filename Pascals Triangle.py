# Link: https://leetcode.com/problems/pascals-triangle/submissions/

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        # If numRows is 1, return hard-written list
        if numRows == 1:
            return [[1]]
        
        # Create a list
        finalList = [[1]]
        
        # Add N rows to list
        for idx in range(numRows - 1):
            
            # Get size of previous row
            prevLength = len(finalList[idx])
            
            # Add a new row with 1 unit size bigger than previous
            finalList.append([1] * (prevLength + 1))
            
        # Iterate triangle
        for xPos in range(2, len(finalList)):
            for yPos in range(1, xPos): # <= NOTE: The Nth row will have N elements!
                
                # Get value of upper-left and upper-right cell
                upperLeft = finalList[xPos - 1][yPos - 1]
                upperRight = finalList[xPos - 1][yPos]
                
                # Update current cell's value
                finalList[xPos][yPos] = upperLeft + upperRight
                
        return finalList
