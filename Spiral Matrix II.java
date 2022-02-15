// Link: https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    
    public void traverse(int[][] matrix, int xPos, int yPos, int startNum, int n, String direction)
    {
        // Exit before triggering out-of-bound error
        if (xPos >= n || xPos < 0 || yPos >= n || yPos < 0) {return;}
        
        // If element already has a value, exit function
        if (matrix[xPos][yPos] != 0) {return;}
        
        // Add startNum to current position
        matrix[xPos][yPos] = startNum;
        startNum++;
        
        // Traverse matrix (up, right, down, left)
        for (int i=0; i<4; i++)
        {
            // After each cell visit, update direction variable
            if (direction == "up")
            {
                traverse(matrix, xPos - 1, yPos, startNum, n, direction);
                direction = "right";
            }
            
            if (direction == "right")
            {
                traverse(matrix, xPos, yPos + 1, startNum, n, direction);
                direction = "down";
            }
            
            if (direction == "down")
            {
                traverse(matrix, xPos + 1, yPos, startNum, n, direction);
                direction = "left";
            }
            
            if (direction == "left")
            {
                traverse(matrix, xPos, yPos - 1, startNum, n, direction);
                direction = "up";
            }
        }
    }
    
    public int[][] generateMatrix(int n) {
        
        // If n == 1, return hard-written matrix
        if (n == 1)
        {
            int[][] tmpMatrix = new int[1][1];
            tmpMatrix[0][0] = n;
            
            return tmpMatrix;
        }
        
        // Create matrix
        int[][] matrix = new int[n][n];
        
        // Traverse matrix
        traverse(matrix, 0, 0, 1, n, "right");
        return matrix;
    }
}
