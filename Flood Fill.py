# https://leetcode.com/problems/flood-fill/

class Solution:
    
    def traverseMatrix(self, image, xPos, yPos, m, n, target, color):
        
        # OBJECTIVE: Traverse matrix and change target to color in every cell
        
        # If xPos and yPos are out of bounds, exit function
        if xPos < 0 or xPos >= m or yPos < 0 or yPos >= n:
            return
        
        # If cell was previously visited, exit function
        if image[xPos][yPos] == -1:
            return
        
        # If this cell's color doesn't equal to target, exit function
        if image[xPos][yPos] != target:
            return
        
        # Set cell's value to -1 for visited
        image[xPos][yPos] = -1
        
        # Visit neighboring cells
        self.traverseMatrix(image, xPos, yPos + 1, m, n, target, color) # right
        self.traverseMatrix(image, xPos + 1, yPos, m, n, target, color) # down
        self.traverseMatrix(image, xPos, yPos - 1, m, n, target, color) # left
        self.traverseMatrix(image, xPos - 1, yPos, m, n, target, color) # up
        
        # Set cell's value to color
        image[xPos][yPos] = color
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        # Traverse matrix
        self.traverseMatrix(image, sr, sc, len(image), len(image[0]), image[sr][sc], color)
        return image
