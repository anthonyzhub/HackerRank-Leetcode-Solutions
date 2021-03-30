# Link: https://leetcode.com/problems/max-area-of-island/submissions/

class Solution:
    
    def numberOfIslands(self, grid, xPos, yPos):
        
        # If X & Y are out-of-bounds, exit function
        if xPos < 0 or xPos >= len(grid) or yPos < 0 or yPos >= len(grid[0]):# or grid[xPos][yPos] == -1:
            return 0
        
        # If cell is water or previously visited land, exit function
        if grid[xPos][yPos] == 0 or grid[xPos][yPos] == -1:
            return 0
        
        # If statement above wasn't met, count this cell as land and keep track of it
        islandSize = 1
        
        # Replace cell's value with something else to avoid walking on the same path
        grid[xPos][yPos] = -1
        
        # Check all directions and update islandSize
        islandSize += self.numberOfIslands(grid, xPos, yPos - 1) # left
        islandSize += self.numberOfIslands(grid, xPos, yPos + 1) # right
        islandSize += self.numberOfIslands(grid, xPos - 1, yPos) # up
        islandSize += self.numberOfIslands(grid, xPos + 1, yPos) # down
        
        # Return size of current island
        return islandSize
    
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        
        # If grid is empty or a NoneType, exit function
        if len(grid) == 0 or grid == None:
            return 0
        
        # Create a variable to track island's size
        islandSize = 0
        
        # Iterate grid
        for xPos in range(len(grid)):
            for yPos in range(len(grid[0])):
                
                # If cell represents land, call function
                if grid[xPos][yPos] == 1:
                    
                    # Keep the highest number representing island's area
                    islandSize = max(islandSize, self.numberOfIslands(grid, xPos, yPos))
        
        return islandSize
