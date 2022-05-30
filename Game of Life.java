// https://leetcode.com/problems/game-of-life/

class Solution {
    
    public void updateCell(int[][] board, int row, int col) {
        
        // Create an array of all possible directions
        int[][] directions = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
        };
        
        // Go through all possible directions
        int cellsAlive = 0;
        for (int[] direction: directions) {
            
            // Temporarily update row and column
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            // Check that neighboring cell isn't out of bounds and its absolute value is 1
            if (0 <= newRow && newRow < board.length && 0 <= newCol && newCol < board[0].length && Math.abs(board[newRow][newCol]) == 1) {
                cellsAlive++;
            }
        }
        
        // Check if cell is alive
        if (board[row][col] == 1) {
            
            // If number of neighboring cells alive is less than 2 or greater than 3, update cell's value to -1
            if (cellsAlive < 2 || cellsAlive > 3) {
                board[row][col] = -1;
            }
        }
        else {
            
            // If number of neighboring cells alive is exactly 3, update cell's value to 2
            if (cellsAlive == 3) {
                board[row][col] = 2;
            }
        }
    }
    
    public void gameOfLife(int[][] board) {
        
        /*
            Rules:
            If cell is 1 and less than 2 are alive, this leads to 0
            If cell is 1 and 2-3 are alive, this leads to 1
            If cell is 1 and more than 3 are alive, this leads to 0
            If cell is 0 and 3 are alive, this leads to 1
        
        IMPORTANT:
                The problem mentions applying the rules simulatenously to every cell in the current state. So, I can't use DFS or BFS.
                
                To solve this, new dead and alive cells will have different values until they're overriden. New dead cells will be denoted as -1. New alive cells will be denoted as 2.
            
        Time Complexity: O(m * n) where m and n represents size of the board. The board is traversed twice separately and
                    the for-loop inside updateCell() will always run 8 loops.
        
        Space Complexity: O(1). Although a directions list was created, it will always take up 8 elements because I will only check 8 neighbors. It's not N since its size won't
                    change, therefore it will remain constant
        */
        
        // Get board's size
        int m = board.length;
        int n = board[0].length;
        
        // Iterate board
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                
                // Update cell's value
                updateCell(board, row, col);
            }
        }
        
        // Iterate board again to update cells' value
        for (int row=0; row<m; row++) {
            for (int col=0; col<n; col++) {
                
                // If cell's value is 2, change it to 1
                if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
                
                // If cell's value is -1, set it to 0
                else if (board[row][col] == -1) {
                    board[row][col] = 0;
                }
            }
        }
    }
}
