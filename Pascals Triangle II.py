# https://leetcode.com/problems/pascals-triangle-ii/submissions/

class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        
        # If rowIndex is 0, return hard-written list
        if rowIndex == 0:
            return [1]
        
        # Create a list
        triangle = [[1]]
        
        # Fill in triangle
        for idx in range(rowIndex):
            
            # Create a new row that is 1 unit longer than previous row
            prevLength = len(triangle[idx])
            triangle.append([1] * (prevLength + 1))
            
        # Iterate triangle
        for xPos in range(2, len(triangle)):
            for yPos in range(1, xPos):
                
                # Get upperleft and upperright cells
                upperLeft = triangle[xPos - 1][yPos - 1]
                upperRight = triangle[xPos - 1][yPos]
                
                # Update current cell's value
                triangle[xPos][yPos] = upperLeft + upperRight
                
        # Return last row
        return triangle[-1]
