# Link: https://leetcode.com/problems/spiral-matrix/submissions/

class Solution(object):
    
    def changeDirection(self, direction):
        
        if direction == "right":
            return "down"
        elif direction == "down":
            return "left"
        elif direction == "left":
            return "up"
        
        return "right"
    
    def traverse(self, matrix, xPos, yPos, routeTaken, direction):
        
        # Stop function from going out-of-bounds
        if xPos < 0 or xPos >= len(matrix) or yPos < 0 or yPos >= len(matrix[0]):
            return self.changeDirection(direction)
        
        # If this cell was previously visited, exit
        if matrix[xPos][yPos] == -101:
            return self.changeDirection(direction)
        
        # Add cell's value to list
        routeTaken.append(matrix[xPos][yPos])
        
        # Change cell's value
        matrix[xPos][yPos] = -101 # <= A cell's value won't be less than -100
        
        # Check all directions
        for _ in range(4):
            
            if direction == "right":
                direction = self.traverse(matrix, xPos, yPos + 1, routeTaken, "right") # right

            if direction == "down":
                direction = self.traverse(matrix, xPos + 1, yPos, routeTaken, "down") # down

            if direction == "left":
                direction = self.traverse(matrix, xPos, yPos - 1, routeTaken, "left") # left

            if direction == "up":
                direction = self.traverse(matrix, xPos - 1, yPos, routeTaken, "up") # up

    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        
        # If matrix is a NoneType, exit function
        if matrix is None:
            return []
        
        # Create a list to keep track of cell's value
        routeTaken = list()
        
        # Traverse matrix
        self.traverse(matrix, 0, 0, routeTaken, "right")
        
        # Return list
        return routeTaken
