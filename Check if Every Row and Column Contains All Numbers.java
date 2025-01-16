// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
/*
Time Complexity: O(n) where n = number of elements inside matrix

Space Complexity: O(n) where n = size of row and column. Set only recorded elements from row and then column, one at a time.
*/

class Solution {

    private boolean areColumnsValid(int[][] matrix, int rowSize, int colSize) {
        for (int i = 0; i < rowSize; i++) {

            Set<Integer> uniqueElems = new HashSet<>();
            for (int j = 0; j < colSize; j++) {

                Integer curElem = Integer.valueOf(matrix[j][i]);
                if (uniqueElems.contains(curElem)) {
                    return false;
                }

                uniqueElems.add(curElem);
            }
        }

        return true;
    }

    private boolean areRowsValid(int[][] matrix, int rowSize, int colSize) {
        for (int i = 0; i < rowSize; i++) {
            Set<Integer> uniqueElems = new HashSet<>();
            for (int j = 0; j < colSize; j++) {

                Integer curElem = Integer.valueOf(matrix[i][j]);
                if (uniqueElems.contains(curElem)) {
                    return false;
                }

                uniqueElems.add(curElem);
            }
        }

        return true;
    }

    public boolean checkValid(int[][] matrix) {
        
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        
        if (areRowsValid(matrix, rowSize, colSize)) {
            return areColumnsValid(matrix, rowSize, colSize);
        }

        return false;
    }
}
