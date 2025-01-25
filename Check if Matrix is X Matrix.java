// https://leetcode.com/problems/check-if-matrix-is-x-matrix/
/*
Time Complexity: O(n^2) where n = size of grid because we're checking every single element inside the matrix.
Space Complexity: O(1) because no additional dynamic memory was created.
*/

class Solution {
    public boolean checkXMatrix(int[][] grid) {

        // Iterate grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {

                int curNumber = grid[row][col];

                // Condition is true if iterator is on a diagonal
                // IMPORTANT: grid.length - col - 1 works when checking if iterator is on the right-to-left diagonal. 
                //  Draw a grid with coordinates written out and test out the formula.
                if (row == col || row == grid.length - col - 1) {
                    if (curNumber == 0) {
                        return false;
                    }
                }
                // Condition is met if iterator isn't on a diagonal
                else {
                    if (curNumber != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
