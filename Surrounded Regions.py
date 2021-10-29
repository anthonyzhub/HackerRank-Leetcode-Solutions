# https://leetcode.com/problems/surrounded-regions/

class Solution:
    
    def dfs(self, board, xPos, yPos):
        
        # Stop from searching outside of the board
        if xPos < 0 or xPos >= len(board) or yPos < 0 or yPos >= len(board[0]):
            return
        
        # Exit if cell already has an X
        if board[xPos][yPos] == "X":
            return
        
        # EXit if cell was already visited
        if board[xPos][yPos] == "visited":
            return
        
        # Change cell's value for "visited"
        board[xPos][yPos] = "visited"
        
        # Check neighboring cells
        self.dfs(board, xPos - 1, yPos)
        self.dfs(board, xPos, yPos + 1)
        self.dfs(board, xPos + 1, yPos)
        self.dfs(board, xPos, yPos - 1)
    
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        # If matrix is empty, exit function
        if board is None:
            return
        
        # If matrix only has 1 row, exit function
        # NOTE: Set this condition because every cell is technically at the edge
        if len(board) == 1:
            return
        
        # Get board dimensions
        width = len(board[0])
        height = len(board)
        
        # Iterate matrix for borders
        for xPos in range(height):
            for yPos in range(width):
                
                # Change border cell values to "visited"
                if xPos in [0, height - 1] or yPos in [0, width - 1]:
                    self.dfs(board, xPos, yPos)
                    
        # Iterate matrix to change "visited" to "O"
        for xPos in range(height):
            for yPos in range(width):
                
                if board[xPos][yPos] == "visited":
                    board[xPos][yPos] = "O"
                else:
                    board[xPos][yPos] = "X"
