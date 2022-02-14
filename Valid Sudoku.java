// Link: https://leetcode.com/problems/valid-sudoku/

class Solution {
    
    public boolean inspectColumns(char[][] board)
    {
        // Inspect columns
        ArrayList<Character> queue = new ArrayList();
        for (int i=0; i<board.length; i++)
        {
            // System.out.println(queue);
            for (int j=0; j<board[i].length; j++)
            {
                // If element already exist, return false
                if (queue.contains(board[j][i])) {return false;}
                
                // If element is a ".", skip to next iteration
                if (board[j][i] == '.') {continue;}
                
                // Add number to queue
                queue.add(board[j][i]);
                // System.out.println(queue);
            }
            // Clear queue
            queue.clear();
        }
        
        return true;
    }
    
    public boolean inspectRows(char[][] board)
    {
        // Inspect rows
        ArrayList<Character> queue = new ArrayList();
        for (int i=0; i<board.length; i++)
        {
            // System.out.println(queue);
            for (int j=0; j<board[i].length; j++)
            {
                // If element already exist, return false
                if (queue.contains(board[i][j])) {return false;}
                
                // If element is a ".", skip to next iteration
                if (board[i][j] == '.') {continue;}
                
                // Add number to queue
                queue.add(board[i][j]);
                // System.out.println(queue);
            }
            
            // Clear queue
            queue.clear();
        }
        
        return true;
    }
    
    public boolean isBoxValid(char[][] board, int row, int col)
    {
        // Create a set
        HashSet<Character> tmpSet = new HashSet();
        
        // Iterate box
        for (int currRow=row; currRow<row + 3; currRow++)
        {
            for (int currCol=col; currCol<col + 3; currCol++)
            {
                // If element is a ".", skip iteration
                if (board[currRow][currCol] == '.') {continue;}
                
                // If element already exist inside set, return false
                if (tmpSet.contains(board[currRow][currCol])) {return false;}
                
                // Add new element to set
                tmpSet.add(board[currRow][currCol]);
            }
        }
        
        return true;
    }
    
    public boolean inspectBox(char[][] board)
    {
        // Visit every box
        for (int i=0; i<board.length; i+=3)
        {
            for (int j=0; j<board[i].length; j+=3)
            {
                // If false, then board is invalid
                if (isBoxValid(board, i, j) == false) {return false;}
            }
        }
        
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        
        // If board is empty, exit function
        if (board == null) {return true;}
        
        // Inspect rows and columns
        boolean inspectRows = inspectRows(board);
        boolean inspectColumns = inspectColumns(board);
        boolean inspectBox = inspectBox(board);
        
        // If either boolean variables is false, then function returns false
        return inspectRows && inspectColumns && inspectBox;
    }
}
