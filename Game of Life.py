# https://leetcode.com/problems/game-of-life/

class Solution:
    
    def updateCell(self, board, row, col):
        
        # Set directions of neighboring cells
        directions = [
            [-1, -1], # top left
            [-1, 0], # top center
            [-1, 1], # top right
            [0, -1], # left
            [0, 1], # right
            [1, -1], # bottom left
            [1, 0], # bottom center
            [1, 1] # bottom right
        ]
        
        # Iterate neighbors
        cellsAlive = 0
        for direction in directions:
            
            # Temporarily update row and column values
            newRow = row + direction[0]
            newCol = col + direction[1]
            
            # If potential neighboring cell isn't out of bounds and its absolute value is 1, increment counter
            if newRow >= 0 and newRow < len(board) and newCol >= 0 and newCol < len(board[0]) and abs(board[newRow][newCol]) == 1:
                cellsAlive += 1
                    
        # Check if cell is alive
        if board[row][col] == 1:
            
            # If cell has 2 or 3 living neighboring cells, set cell's value to -1
            if cellsAlive < 2 or cellsAlive > 3:
                board[row][col] = -1
                
        else:
            
            # If cell has exactly 3 living neighboring cells, set cell's value to 2
            if cellsAlive == 3:
                board[row][col] = 2
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
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
        
        Space Complexity: O(1). Although a directions list was created, it will always take up 8 elements because I will only check 8 neighbors. It's not N since its size won't change, therefore it will remain constant
        """
        
        # If matrix is empty, exit function
        if len(board) == 0:
            return
        
        # Get board's dimensions
        m = len(board)
        n = len(board[0])
        
        # Iterate board
        for row in range(m):
            for col in range(n):
                
                # Update cell's value in duplicate from board
                self.updateCell(board, row, col)
                
        # Iterate board again to update cell's value
        for row in range(m):
            for col in range(n):
                
                # If cell's value is 2, set it to 1
                if board[row][col] == 2:
                    board[row][col] = 1
                
                # If cell's value is -1, set it to 0
                elif board[row][col] == -1:
                    board[row][col] = 0
