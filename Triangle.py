# https://leetcode.com/problems/triangle/submissions/

class Solution:
    
    def printMatrix(self, triangle):
        
        for row in range(len(triangle)):
            currRow = ' '.join(str(i) for i in triangle[row])
            print(currRow)
            
        print()
        
    def minimumTotal(self, triangle):
        
        # If matrix only has 1 element (tip of the triangle), return it
        if len(triangle) == 1:
            return triangle[0][0]
        
        # Iterate triangle
        for xPos in range(len(triangle) - 2, -1, -1): # <= Go from the bottom-up starting at 2nd to last row, go to highest row, and move in reverse order 
            for yPos in range(len(triangle[xPos])): # <= Iterate row
                
                # Get smallest element in row below
                minElem = min(triangle[xPos + 1][yPos], triangle[xPos + 1][yPos + 1])
                
                # Add smallest element to cell's current value
                triangle[xPos][yPos] += minElem
                
        # NOTE: Top cell will hold the minimum path sum
        return triangle[0][0]

sol = Solution()
triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]

sol.printMatrix(triangle)
sol.minimumTotal(triangle)
sol.printMatrix(triangle)
