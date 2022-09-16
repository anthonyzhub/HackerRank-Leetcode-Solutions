// https://leetcode.com/problems/flood-fill/

class Solution {
    
    public void traverseMatrix(int[][] image, int xPos, int yPos, int m, int n, int target, int color) {
        
        // OBJECTIVE: Traverse matrix and change cell's value from target to color
        
        // If xPos and yPos go out of bounds, exit function
        if (xPos < 0 || xPos >= m || yPos < 0 || yPos >= n) {return;}
        
        // If cell was previously visited, exit function
        if (image[xPos][yPos] == -1) {return;}
        
        // If cell's value doesn't equal to target, exit function
        if (image[xPos][yPos] != target) {return;}
        
        // Change cell's value to -1 for visited
        image[xPos][yPos] = -1;
        
        // Visit neighboring cells
        traverseMatrix(image, xPos, yPos + 1, m, n, target, color); // right
        traverseMatrix(image, xPos + 1, yPos, m, n, target, color); // down
        traverseMatrix(image, xPos, yPos - 1, m, n, target, color); // left
        traverseMatrix(image, xPos - 1, yPos, m, n, target, color); // up
        
        // Change cell's value to target
        image[xPos][yPos] = color;
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        // Traverse matrix
        traverseMatrix(image, sr, sc, image.length, image[0].length, image[sr][sc], color);
        return image;
    }
}
