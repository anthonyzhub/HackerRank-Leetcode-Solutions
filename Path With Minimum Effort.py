# Link: https://leetcode.com/problems/path-with-minimum-effort/solution/

class Solution:
    
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        
        # Get matrix's size
        xSize = len(heights)
        ySize = len(heights[0])
        
        # Create a new matrix where each cell represents the difference between neighboring cells
        differenceMatrix = [[math.inf] * ySize for _ in range(xSize)]
        differenceMatrix[0][0] = 0 # <= The start point is heights[0][0], so difference is 0
 
        # Create a matrix where it keeps track of cells that have been visited
        visitedMatrix = [[False] * ySize for _ in range(xSize)]
        
        # Create a list to keep track of routes visited
        queue = [(0, 0, 0)] # (difference, xPos, yPos)
        
        while queue:
            
            # Get route from queue
            difference, xPos, yPos = heapq.heappop(queue)
            
            # Mark that cell was visited
            visitedMatrix[xPos][yPos] = True
            
            # Iterate all possible directions (right, up, left, down)
            for dx, dy in [[0,1], [1,0], [-1,0], [0,-1]]:
                
                # Get X & Y value of next cell
                nextX = xPos + dx
                nextY = yPos + dy
                
                # Check if cell isn't out of bounds and wasn't visited before
                if 0 <= nextX < xSize and 0 <= nextY < ySize and visitedMatrix[nextX][nextY] == False:
                    
                    # Calculate difference between current cell and adjacent cell
                    currDifference = abs(heights[nextX][nextY] - heights[xPos][yPos])
                    
                    # Find out which route has the smallest difference
                    maxDifference = max(currDifference, differenceMatrix[xPos][yPos])

                    # Check if difference of next cell is greater than maxDifference
                    if differenceMatrix[nextX][nextY] > maxDifference:
                        
                        # Update cell to smallest max value
                        differenceMatrix[nextX][nextY] = maxDifference
                        
                        # Add new route to list
                        heapq.heappush(queue, (maxDifference, nextX, nextY))
                        
        return differenceMatrix[-1][-1]
