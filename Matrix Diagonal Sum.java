// https://leetcode.com/problems/matrix-diagonal-sum/
/*
Time Complexity: O(n) where n = length of mat. Mat is a perfect square and I'm iterating through matrix diagonally
Space Complexity: O(1) because no additional dynamic memory was created

IMPORTANT: It's best to draw out a grid and to write out the coordinates of each box that you're adding. This will help
  understand why I created such functions with such conditions.
*/

class Solution {

    private int calculateFromLeftToRight(int[][] mat) {
        int sum = 0;

        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
        }

        return sum;
    }

    private int calculateFromRightToLeft(int[][] mat) {
        int sum = 0;

        int row = 0;
        int col = mat.length - 1;

        while (row < mat.length && col >= 0) {
            sum += mat[row][col];
            row++;
            col--;
        }

        return sum;
    }

    public int diagonalSum(int[][] mat) {
        if (mat.length == 1) {
            return mat[0][0];
        }

        int leftToRightDiagonalSum = calculateFromLeftToRight(mat);
        int rightToLeftDiagonalSum = calculateFromRightToLeft(mat);

        // IMPORTANT: If n is even, then the middle value wasn't added twice
        if (mat.length % 2 == 0) {
            return leftToRightDiagonalSum + rightToLeftDiagonalSum;
        }

        // IMPORTANT: If n is odd, then middle value was added twice
        int midValue = mat[mat.length / 2][mat.length / 2];
        return (leftToRightDiagonalSum + rightToLeftDiagonalSum) - midValue;
    }
}
