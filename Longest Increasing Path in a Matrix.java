// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

class Solution {
    
    public int traverse(int[][] matrix, int xPos, int yPos, int preCell, HashMap<Pair<Integer, Integer>, Integer> memo) {
        
        // If xPos and yPos go out of bounds, exit function
        if (xPos < 0 || xPos >= matrix.length || yPos < 0 || yPos >= matrix[0].length) {
            return 0;
        }
        
        // If preCell is greater than or equal to this cell's value, exit function
        if (preCell >= matrix[xPos][yPos]) {
            return 0;
        }
        
        // If this cell was already visited, return its value. The value indicates how long the longest increasing path is from this point
        Pair<Integer, Integer> cell = new Pair<Integer, Integer>(xPos, yPos);
        if (memo.containsKey(cell)) {
            return memo.get(cell);
        }
        
        // Create a variable to start counting how long the longest increasing path is from this point
        int res = 1;
        
        // Make a recursive call
        res = Math.max(res, 1 + traverse(matrix, xPos, yPos + 1, matrix[xPos][yPos], memo));
        res = Math.max(res, 1 + traverse(matrix, xPos + 1, yPos, matrix[xPos][yPos], memo));
        res = Math.max(res, 1 + traverse(matrix, xPos, yPos - 1, matrix[xPos][yPos], memo));
        res = Math.max(res, 1 + traverse(matrix, xPos - 1, yPos, matrix[xPos][yPos], memo));
        
        // Save this cell and the length of its longest increasing path to memo
        memo.put(cell, res);
        
        // Return cell's longest increasing path's length
        return res;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        /*
        OBJECTIVE: Given an m x n integers matrix, return the length of the longest increasing path in matrix.
        
        Time Complexity: O(m * n) where m and n are the matrix's dimensions. The for-loop in longestIncreasingPath() iterates the matrix and calls traverse() per cell.
                        Each cell acts as a new starting point. In traverse(), each cell checks their neighbors and check if it's possible to create a path with them.
                        Every cell records their longest path in a dictionary. Memoization helps to run the program by not re-checking the length of the longest
                        increasing path in every cell per cell call.
        
        Space Complexity: O(m * n) where m and n are the matrix's dimensions. Same reasoning as above.
        */
        
        // Get matrix's dimensions
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Create a hash map where key are coordinates and value is a number representing the length of the longest increasing path with key as starting point
        HashMap<Pair<Integer, Integer>, Integer> memo = new HashMap<Pair<Integer, Integer>, Integer>();
        
        // Iterate matrix
        int maxLen = 0;
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                
                // Calculate how long the longest increasing path will be from this starting point
                int curLen = traverse(matrix, i, j, -1, memo);
                
                // If curLen equals to the number of existing elements inside the matrix, exit function
                // E.g., If there are 9 elements in this array and curLen equals to 9, then there aren't any more elements to check
                if (curLen == m*n) {
                    return curLen;
                }
                
                // If function is still continuing, update maxLen
                maxLen = Math.max(maxLen, curLen);
            }
        }
        
        return maxLen;
    }
}
