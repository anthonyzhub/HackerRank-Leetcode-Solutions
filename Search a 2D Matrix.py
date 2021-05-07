# Link: https://leetcode.com/problems/search-a-2d-matrix/submissions/

class Solution(object):
    
    def binarySearch(self, matrix, low, high, target):
        
        if high >= low:
            
            # Get midpoint
            midPoint = (high + low) // 2
            
            # If element is at midPoint, return true
            if matrix[midPoint] == target:
                return True
            
            elif matrix[midPoint] > target:
                return self.binarySearch(matrix, low, midPoint - 1, target)
            
            else:
                return self.binarySearch(matrix, midPoint + 1, high, target)
            
        else:
            return False
    
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        
        # If matrix is NoneType, exit function
        if matrix is None:
            return False
        
        # Get midpoint of matrix
        midRow = len(matrix) // 2
        
        # If matrix only has 1 row, continue to while-loop
        if len(matrix) != 1:
            
            # Check if 1st element of midRow equals to target
            if target > matrix[midRow][0]:
                return self.searchMatrix(matrix[midRow:], target)

            elif target < matrix[midRow][0]:
                return self.searchMatrix(matrix[:midRow], target)
                
        # If target is potentially inside midRow, break down row
        # NOTE: Only send a single row from the matrix. Not the matrix!
        return self.binarySearch(matrix[midRow], 0, len(matrix[0]) - 1, target)
