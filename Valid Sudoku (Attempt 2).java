// https://leetcode.com/problems/valid-sudoku/

class Solution {

    private boolean isRowValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                Character curChar = Character.valueOf(board[i][j]);

                if (curChar != '.') {
                    if (row.contains(curChar)) {
                        return false;
                    } else {
                        row.add(curChar);
                    }
                }
            }
        }

        return true;
    }

    private boolean isColumnValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> column = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                Character curChar = Character.valueOf(board[j][i]);

                if (curChar != '.') {
                    if (column.contains(curChar)) {
                        return false;
                    } else {
                        column.add(curChar);
                    }
                }
            }
        }

        return true;
    }

    private boolean inspectBox(char[][] board, int minX, int minY, int maxX, int maxY) {
        Set<Character> box = new HashSet<>();

        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                Character curChar = Character.valueOf(board[i][j]);
                if (curChar != '.') {
                    if (box.contains(curChar)) {
                        return false;
                    } else {
                        box.add(curChar);
                    }
                }
            }
        }

        return true;
    }

    private boolean isBoxValid(char[][] board) {
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!inspectBox(board, i, j, i + 3, j + 3)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (isRowValid(board)) {
            if (isColumnValid(board)) {
                if (isBoxValid(board)) {
                    return true;
                }
            }
        }

        return false;
    }
}
