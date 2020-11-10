# Link: https://leetcode.com/problems/number-of-islands/submissions/

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        total = 0
        
        # Iterate grid
        for i in range(len(grid)):
            for j in range(len(grid[0])): # <= Typed grid[0] because each row shared same length
                
                # Perform depth first search
                if grid[i][j] == '1':
                    self.dfs(grid, i, j) # Travel in all possible paths
                    total += 1
                    
        return total
                
    def dfs(self, grid, i, j):
        
        """
        i >= len(grid)
        i < 0: Stop if you're out of bounds inside the row
        
        j >= len(grid[0]):
        j < 0: Stop if you're out of bounds inside the column
        
        grid[i][j]: Stop if element at i, j is not 1
        
        path[i][j]: Stop if position has already been visited
        """
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] != '1':
            return
            
        # Keep record of recent position
        grid[i][j] = 'V'
            
        # Check top side
        self.dfs(grid, i, j + 1)
        
        # Check left side
        self.dfs(grid, i - 1, j)
        
        # Check bottom side
        self.dfs(grid, i, j - 1)
        
        # Check right side
        self.dfs(grid, i + 1, j)
