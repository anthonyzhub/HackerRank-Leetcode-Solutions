# Link: https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/

class Solution(object):
    
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        """
        NOTE: Start searching the matrix from top-right corner.
        
        1. If target is greater than top-right element, move to left column
        2. If target is less than top-right element, move down the column
        3. Repeat until element is found
        """
        
        # If matrix is a NoneType, exit function
        if matrix is None:
            return False
        
        # Get matrix's dimension
        x = len(matrix[0]) - 1
        y = 0
        
        # Iterate matrix
        while x >= 0 and y < len(matrix):
            
            # If cell's value is greater than target, move left one column
            if matrix[y][x] > target:
                x -= 1
                
            # If cell's value is greater than target, move down one row
            elif matrix[y][x] < target:
                y += 1
                
            # Return true because target was found inside matrix
            else:
                return True
            
        # If while-loop ends, return false because target doesn't exist
        return False
