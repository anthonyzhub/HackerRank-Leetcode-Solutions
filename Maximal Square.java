// https://leetcode.com/problems/maximal-square
/*
Time Complexity: O(m*n) where m & n is the size of the input matrix.

Space Complexity: O(m*n) where m & n is the size of cache.
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        // If matrix isn't a perfect square, return 0
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[][] cache = new int[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                if (matrix[i][j] == '1') {

                    // If cell is at en edge, copy its value to cache
                    if (i == 0 || j == 0) {
                        cache[i][j] = 1;
                    } else {

                        int topLeftVal = cache[i-1][j-1];
                        int leftVal = cache[i][j-1];
                        int topVal = cache[i-1][j]

                        // Get the smallest value and add its own value
                        // NOTE: If there's even one 0, then a square can't be made here.
                        cache[i][j] = Math.min(
                            Math.min(leftVal, topVal),
                            topLeftVal
                        ) + 1;
                    }
                }
            }
        }

        int maxNum = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                maxNum = Math.max(maxNum, cache[i][j]);
            }
        }

        // NOTE: Problem is asking for area of a square.
        return (int) Math.pow(maxNum, 2);
    }
}
