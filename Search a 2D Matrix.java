// https://leetcode.com/problems/search-a-2d-matrix/
/*
Time Complexity: O(log(m * n)) where m and n are the dimensions of the matrix. 
    Binary search is used to first look for the target row, and then performed again to look for target in said row.

Space Complexity: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int maxRows = matrix.length, maxCols = matrix[0].length;

        // Look for row that potentially has target
        int topPtr = 0, bottomPtr = maxRows - 1;
        while (topPtr <= bottomPtr) {
            int midPtr = topPtr + ((bottomPtr - topPtr) / 2);
            int firstElem = matrix[midPtr][0];
            int lastElem = matrix[midPtr][maxCols - 1];

            if (firstElem > target) { // If first elem > target, then search top-half of matrix
                bottomPtr = midPtr - 1;
            } else if (lastElem < target) { // If last elem < target, then search bottom-half of matrix
                topPtr = midPtr + 1;
            } else { // If first element <= target <= last element in curRow
                break;
            }
        }

        // Check if above condition was broken. If so, target doesn't exist in matrix
        if (topPtr > bottomPtr) {
            return false;
        }

        // Perform binary search again, but on target row
        int leftPtr = 0, rightPtr = maxCols - 1;
        int targetRow = topPtr + ((bottomPtr - topPtr) / 2);
        while (leftPtr <= rightPtr) {

            int midPtr = leftPtr + ((rightPtr - leftPtr) / 2);
            
            if (matrix[targetRow][midPtr] > target) { // If middle element > target, search left-hand side 
                rightPtr = midPtr - 1;
            } else if (matrix[targetRow][midPtr] < target) { // If middle element < target, search right-hand side
                leftPtr = midPtr + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
