# Link: https://leetcode.com/problems/minimum-path-sum/submissions/

class Solution(object):
        
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        # If grid is a NoneType, exit function
        if grid is None:
            return
        
        # Get grid's dimensions
        m = len(grid)
        n = len(grid[0])
        
        # Iterate first row
        for i in range(1, n):
            grid[0][i] += grid[0][i - 1] # <= Add current cell's and left cell's value
            
        # Iterate first column
        for j in range(1, m):
            grid[j][0] += grid[j - 1][0] # <= Add current cell's and top cell's value
            
        # Iterate inner grid
        for xPos in range(1, m):
            for yPos in range(1, n):
                
                # Update cell's value
                # NOTE: Only check left and top cell.
                grid[xPos][yPos] += min(grid[xPos - 1][yPos], grid[xPos][yPos - 1])
                
        # Return changed value of bottom-right cell
        return grid[-1][-1]
