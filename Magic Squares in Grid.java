// https://leetcode.com/problems/magic-squares-in-grid/
/*
Time Complexity: O(m*n) where m*n is the size of the grid
Space Complexity: O(1) because the hashset will always hold at most 9 numbers.
*/

class Solution {

    private boolean validateMagicSquare(int[][] grid, int curRow, int curCol) {

        Set<Integer> uniqueNums = new HashSet<>();

        // Check if there are any duplicates or if 1 <= given number <= 9 isn't true
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int curNum = grid[curRow + i][curCol + j];
                if (uniqueNums.contains(curNum) || curNum <= 0 || curNum >= 10) {
                    return false;
                }
                uniqueNums.add(curNum);
            }
        }

        // Calculate sum of 1st row. It will be used to compare it again the sum of each row/column/diagonal
        int requiredSum = grid[curRow][curCol] + grid[curRow][curCol + 1] + grid[curRow][curCol + 2];

        // Check if sum of each row equals to requiredSum
        for (int i = 0; i < 3; i++) {
            int curSum = grid[curRow + i][curCol] + 
                grid[curRow + i][curCol + 1] + 
                grid[curRow + i][curCol + 2];
            
            if (requiredSum != curSum) {
                return false;
            }
        }

        // Check if sum of each column equals to requiredSum
        for (int i = 0; i < 3; i++) {
            int curSum = grid[curRow][curCol + i] + 
                grid[curRow + 1][curCol + i] + 
                grid[curRow + 2][curCol + i];
            
            if (requiredSum != curSum) {
                return false;
            }
        }

        // Check if sum of each diagonal equals to requiredSum
        int leftToRightDiagonal = grid[curRow][curCol] + grid[curRow + 1][curCol + 1] + grid[curRow + 2][curCol + 2];
        int rightToLeftDiagonal = grid[curRow][curCol + 2] + grid[curRow + 1][curCol + 1] + grid[curRow + 2][curCol];

        if (requiredSum != leftToRightDiagonal) {
            return false;
        } else if (requiredSum != rightToLeftDiagonal) {
            return false;
        } else {
            return true;
        }
    }

    public int numMagicSquaresInside(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // If grid is less than 3x3, then a magic square wouldn't exist.
        if (rows < 3 || cols < 3) {
            return 0;
        }

        int result = 0;

        // Check at each index and create a 3x3 grid from there
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (validateMagicSquare(grid, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }
}
