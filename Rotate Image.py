# Link: https://leetcode.com/problems/rotate-image/submissions/

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        
        # Get matrix's dimensions
        height = len(matrix)
        width = len(matrix[0])
        
        # Iterate matrix
        for xPos in range(width // 2 + width % 2): # <= Go to midpoint and add remainder, if there is one. 
            for yPos in range(width // 2): # <= Go to midpoint again
                
                # If xPos and yPos are at the center of the matrix, continue to next element
                if xPos == height // 2 and yPos == width // 2:
                    continue
                
                # Grab bottom-left element
                tmp = matrix[width - 1 - yPos][xPos]
                
                # Swap bottom-left with bottom-right
                matrix[width - 1 - yPos][xPos] = matrix[width - 1 - xPos][width - yPos - 1]
                
                # Swap bottom-right with upper-right
                matrix[width - 1 - xPos][width - yPos - 1] = matrix[yPos][width - 1 - xPos]
                
                # Swap upper-left with upper-right
                matrix[yPos][width - 1 - xPos] = matrix[xPos][yPos]
                
                # Swap bottom-left with upper-left
                matrix[xPos][yPos] = tmp
