# Link: https://leetcode.com/problems/number-of-closed-islands/submissions/

class Solution:
    
    def dfs(self, grid, xPos, yPos, visitedCells):
        
        # If cell is out of bounds, exit function
        if xPos < 0 or xPos >= len(grid) or yPos < 0 or yPos >= len(grid[0]):
            return False
        
        # If cell is water, exit function
        if grid[xPos][yPos] == 1:
            return True # <= Return true because a closed island needs to have neighboring water
        
        # If cell was already visited, then it is already valid
        if (xPos,yPos) in visitedCells:
            return True
        
        # Add new cell to list
        visitedCells.append((xPos,yPos))
        
        # Check neighboring cells
        up = self.dfs(grid, xPos - 1, yPos, visitedCells)
        down = self.dfs(grid, xPos + 1, yPos, visitedCells)
        left = self.dfs(grid, xPos, yPos - 1, visitedCells)
        right = self.dfs(grid, xPos, yPos + 1, visitedCells)
        
        # Return status of neighboring cells
        # NOTE: If one variable is false, then function will return false (not a closed island)
        return up and down and left and right
    
    def closedIsland(self, grid: List[List[int]]) -> int:
        
        closedIslands = 0
        visitedCells = list()
        
        # Iterate grid
        for x in range(len(grid)):
            for y in range(len(grid[0])):
                
                # Start search on new land only
                if grid[x][y] == 0 and (x,y) not in visitedCells:
                    
                    # Check if cell is a valid closed island
                    output = self.dfs(grid, x, y, visitedCells)
                    
                    if output == True:
                        closedIslands += 1
        
        return closedIslands
