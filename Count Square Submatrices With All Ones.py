# Link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/

class Solution:
    
    def countSquares(self, matrix: List[List[int]]) -> int:
        
        # If matrix is empty, return 0
        if matrix == None or len(matrix) == 0:
            return 0
        
        # Get matrix's dimensions
        m = len(matrix)
        n = len(matrix[0])
        
        totalSquares = 0
        
        # Iterate matrix
        for x in range(m):
            for y in range(n):
                
                # If cell equals 1 and is at the edge, then it's a 1 sided square
                if matrix[x][y] == 1 and (x == 0 or y == 0):
                    
                    totalSquares += 1
                    
                elif matrix[x][y] == 1:
                    
                    # Get neighboring cells
                    topLeftCell = matrix[x-1][y-1]
                    bottomRightCell = matrix[x][y-1]
                    bottomLeftCell = matrix[x-1][y]
                    
                    # Get minimum value of each cell
                    # NOTE: If minVal equals 1, then there's a 0 among the group. If true,
                    #       then current cell is a one sided square
                    minVal = min(topLeftCell, bottomLeftCell, bottomRightCell) + 1
                    
                    # Update number of squares inside the matrix
                    totalSquares += minVal
                    
                    # Change cell's value
                    matrix[x][y] = minVal # <= Tells future iteration if it's by itself or part of a bigger N-sided square
                    
        return totalSquares
                    
