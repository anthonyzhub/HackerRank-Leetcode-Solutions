// https://leetcode.com/problems/valid-sudoku/
/*
Time Complexity: O(n^2) where n = number of elements inside board. We're checking all the elements in each row, column, and box.

Space Complexity: O(n) where n = number of elements inside set per row, column, and box. In my opinion, it's O(n) instead of 
    O(n^2) because each set is cleared per loop (not just nested loops).
*/

class Solution {

    private boolean areColumnsValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            
            Set<Character> uniqueElems = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                
                Character curChar = Character.valueOf(board[j][i]);

                if (curChar.charValue() == '.') {
                    continue;
                }

                if (uniqueElems.contains(curChar)) {
                    return false;
                }

                uniqueElems.add(curChar);
            }
        }

        return true;
    }

    private boolean areRowsValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            
            Set<Character> uniqueElems = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                
                Character curChar = Character.valueOf(board[i][j]);

                if (curChar.charValue() == '.') {
                    continue;
                }

                if (uniqueElems.contains(curChar)) {
                    return false;
                }

                uniqueElems.add(curChar);
            }
        }

        return true;
    }

    private boolean isBoxValid(char[][] board,  int row, int col) {
        
        // IMPORTANT: This set has to be declared outside, unlike the others, because it's checking the boxes.
        //  If it was placed inside before the inner for-loop, it would only keep track of the elements on one row
        //  at a time per box. (i.e., set would have been clear once loop reached the 2nd loop of the inside of the
        //  box.)
        Set<Character> uniqueElems = new HashSet<>();

        for (int curRow = row; curRow < row + 3; curRow++) {
            for (int curCol = col; curCol < col + 3; curCol++) {

                Character curCharacter = Character.valueOf(board[curRow][curCol]);

                if (curCharacter.charValue() == '.') {
                    continue;
                }

                if (uniqueElems.contains(curCharacter)) {
                    return false;
                }

                uniqueElems.add(curCharacter);
            }
        }

        return true;
    }

    private boolean areBoxesValid(char[][] board) {

        // IMPORTANT: Added "+= 3" because iterator would have enter a new box every 3 rows and columns.
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {

                // IMPORTANT: We're starting at the top-left corner of each box for validation
                if (!isBoxValid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        
        // IMPORTANT: If either validation fails, immediately stop validation and return false
        if (areBoxesValid(board)) {
            
            if (areColumnsValid(board)) {
                return areRowsValid(board);
            }

            return false;
        }

        return false;
    }
}
