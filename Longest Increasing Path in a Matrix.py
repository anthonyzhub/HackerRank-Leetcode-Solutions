# https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

class Solution:
    
    def traverse(self, matrix: List[List[int]], xPos: int, yPos: int, preCell: int, memo: dict):
        
        # If xPos or yPos are out of bounds, exit function
        if xPos < 0 or xPos >= len(matrix) or yPos < 0 or yPos >= len(matrix[0]):
            return 0
        
        # If preCell is greater than or equal to this cell's value, exit function
        if preCell >= matrix[xPos][yPos]:
            return 0
        
        # If this cell was already visited, return its value. The value indicates how long the is the increasing path from this point
        if (xPos, yPos) in memo:
            return memo[(xPos, yPos)]
        
        # Create a variable to start counting how long the longest increasing path is from this point
        res = 1
        
        # Make a recursive call
        res = max(res, 1 + self.traverse(matrix, xPos, yPos + 1, matrix[xPos][yPos], memo))
        res = max(res, 1 + self.traverse(matrix, xPos - 1, yPos, matrix[xPos][yPos], memo))
        res = max(res, 1 + self.traverse(matrix, xPos, yPos - 1, matrix[xPos][yPos], memo))
        res = max(res, 1 + self.traverse(matrix, xPos + 1, yPos, matrix[xPos][yPos], memo))
        
        # Save this cell and the length of its longest increasing path to memo
        memo[(xPos, yPos)] = res
        
        # Return cell's longest increasing path's length
        return res
    
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        
        """
        OBJECTIVE: Given an m x n integers matrix, return the length of the longest increasing path in matrix.
        
        Time Complexity: O(m * n) where m and n are the matrix's dimensions. The for-loop in longestIncreasingPath() iterates the matrix and calls traverse() per cell.
                        Each cell acts as a new starting point. In traverse(), each cell checks their neighbors and check if it's possible to create a path with them.
                        Every cell records their longest path in a dictionary. Memoization helps to run the program by not re-checking the length of the longest
                        increasing path in every cell per cell call.
        
        Space Complexity: O(m * n) where m and n are the matrix's dimensions. Same reasoning as above.
        
        """
        
        # Get matrix's size
        m = len(matrix)
        n = len(matrix[0])
        
        # Create a dictionary where key are coordinates and value is a number representing the length of the longest increasing path with key as starting point
        memo = dict()
        
        # Iterate matrix
        maxLen = 0
        for i in range(m):
            for j in range(n):
                
                # Calculate longest increasing path in matrix starting for this point
                curLen = self.traverse(matrix, i, j, -1, memo)
                
                # If curLen equals to the number of elements inside matrix, then exit function
                # E.g., If there are 9 elements in this array and curLen equals to 9, then there aren't any more elements to check
                if curLen == m*n:
                    return curLen
                
                # If function is still continuing, update maxLen
                maxLen = max(maxLen, curLen)
                
        return maxLen
                
        
