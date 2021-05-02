# Link: https://leetcode.com/problems/unique-paths-ii/submissions/

class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        
        # If matrix is a NoneType, return 0
        if obstacleGrid is None:
            return 0
        
        # If upper-right cell has an obstacle, then robot cannot move
        if obstacleGrid[0][0] == 1:
            return 0
        else:
            obstacleGrid[0][0] = 1 # <= Replace it with 1 for future summation of nearby cells
        
        # Iterate 1st row only
        for i in range(1, len(obstacleGrid[0])):
            
            # If current cell equals 0 and left cell equals 1, set current cell to 1
            if obstacleGrid[0][i] == 0 and obstacleGrid[0][i - 1]:
                obstacleGrid[0][i] = 1
            else:
                obstacleGrid[0][i] = 0
        
        # Iterate 1st column only
        for j in range(1, len(obstacleGrid)):
            
            # If current cell equals 0 and top cell equals 1, set current cell to 1
            if obstacleGrid[j][0] == 0 and obstacleGrid[j - 1][0]:
                obstacleGrid[j][0] = 1
            else:
                obstacleGrid[j][0] = 0
        
        # Iterate list to inspect other remaining cells
        for xPos in range(1, len(obstacleGrid)):
            for yPos in range(1, len(obstacleGrid[0])):
                    
                # If a cell is 0, replace cell's value for sum of top and left cell
                if obstacleGrid[xPos][yPos] == 0:
                    obstacleGrid[xPos][yPos] = obstacleGrid[xPos - 1][yPos] + obstacleGrid[xPos][yPos - 1]
                    
                else:
                    
                    # If the cell is 1 (obstacle), replace it with a 0 to not influence future summation
                    obstacleGrid[xPos][yPos] = 0
            
        return obstacleGrid[-1][-1]
