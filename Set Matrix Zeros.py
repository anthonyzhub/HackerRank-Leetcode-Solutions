# Link: https://leetcode.com/problems/set-matrix-zeroes/submissions/

class Solution(object):
    
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        
        # If matrix is a NoneType, exit function
        if matrix is None:
            return matrix
        
        # Get dimensions of matrix
        rows = len(matrix)
        cols = len(matrix[0])
        
        # Create a list to hold coordinates of all cells that equal to 0
        cellRecorder = list()
        
        # Iterate matrix
        for xPos in range(rows):
            for yPos in range(cols):
                
                # If cell equals 0, call other function
                if matrix[xPos][yPos] == 0:
                    cellRecorder.append((xPos, yPos))
                
        # Change matrix
        for cell in cellRecorder:
            
            # Unpack tuple
            xPos, yPos = cell[0], cell[1]
            
            # Change row and column
            matrix[xPos] = [0] * cols
            for i in range(rows):
                matrix[i][yPos] = 0
        
        # Return matrix
        return matrix
