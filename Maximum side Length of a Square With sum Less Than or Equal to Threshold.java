/*
https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

Time Complexity: O(m * n) where m x n is the size of the input matrix.

Space Complexity: O(m * n) where m x n is the size of the prefix matrix.
*/


class Solution {

    private boolean isSquareValid(int[][] prefixMat, int curSize, int threshold) {
        int m = prefixMat.length;
        int n = prefixMat[0].length;

        for (int i = curSize - 1; i < m; i++) {
            for (int j = curSize - 1; j < n; j++) {

                // Define top-left corner of subsquare
                // NOTE: +1 is added because array is index based 0
                int startPointX = i - curSize + 1;
                int startPointY = j - curSize + 1;

                // Get sum of starting point from prefix matrix
                int curSum = prefixMat[i][j];

                // Remove sum from above and left-side of array
                // NOTE: When computing prefix sum, cell (i,j) = (i - 1, j) + (i, j - 1)
                if (startPointX > 0) {
                    curSum -= prefixMat[startPointX - 1][j];
                }

                if (startPointY > 0) {
                    curSum -= prefixMat[i][startPointY - 1];
                }

                // If we deleted the intersection of top & left square, we accidentally deleted from sum twice.
                // Therefore, re-add prefix sum of top-left cell (from current cell) once
                if (startPointX > 0 && startPointY > 0) {
                    curSum += prefixMat[startPointX - 1][startPointY - 1];
                }

                // If we reached the threshold, immediately exit function
                // NOTE: Problem stated cells will only have positive values
                if (curSum <= threshold) {
                    return true;
                }
            }
        }

        // If function is still continuing, return false by default
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        if (m == 1 && n == 1) {
            return mat[0][0] <= threshold ? 1 : 0;
        }
        
        int[][] prefixMat = new int[m][n];

        // Copy mat to prefixMat
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, prefixMat[i], 0, n);
        }

        // Perform prefix sum for rows
        // NOTE: j starts at 1 because cell at (0,0) will cause an out-of-bounds error
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefixMat[i][j] += prefixMat[i][j - 1];
            }
        }

        // Perform prefix sum for columns
        // NOTE: j starts at 1 because cell at (0,0) will cause an out-of-bounds error
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                prefixMat[i][j] += prefixMat[i - 1][j];
            }
        }

        // Define max size of perfect square inside mat[]
        int topLeft = 1;
        int bottomRight = Math.min(m, n); // NOTE: mat[] might not be a perfect square

        // Create a return variable
        int res = 0;

        // Perform a Binary Search on entire matrix
        // NOTE: Binary Search will tell us to increase subsquare size or not
        while (topLeft <= bottomRight) {

            // Get half of max potential size
            // NOTE: Think of this as midPtr
            int curSize = (topLeft + bottomRight) / 2;

            // Check if subsquare of size curSize is valid
            // I.e., Is sum of subsquare <= threshold?
            boolean isValid = isSquareValid(prefixMat, curSize, threshold);

            // If subsquare is valid, check if we can make the square bigger.
            // If not, make it smaller.
            if (isValid) {
                res = curSize;
                topLeft = curSize + 1;
            } else {
                bottomRight = curSize - 1;
            }
        }

        return res;
    }
}
