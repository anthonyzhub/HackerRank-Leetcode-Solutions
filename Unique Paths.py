# Link: https://leetcode.com/problems/unique-paths/submissions/

class Solution(object):
    
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        
        # Create a matrix
        matrix = [[1] * n] * m
        
        # Traverse matrix from neighboring top-left cell
        for xPos in range(1, m):
            for yPos in range(1, n):
                
                # Each cell will have a number representing how many ways there are to reach them.
                # Add the left cell and top cell to get the number of ways to reach current cell.
                # Do this to every single cell inside matrix.
                matrix[xPos][yPos] = matrix[xPos][yPos - 1] + matrix[xPos - 1][yPos]
                
        # Return the value of the bottom-right cell
        return matrix[-1][-1]
