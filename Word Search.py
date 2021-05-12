# Link: https://leetcode.com/problems/word-search/submissions/

class Solution(object):
    
    def traverseMatrix(self, matrix, xPos, yPos, word, wordPos):
        
        # If wordPos equals length of word, then the word has been found inside the matrix
        # NOTE: This has to be here before next if-condition is executed.
        if wordPos == len(word):
            return True
        
        # Stop function from going out-of-bounds
        if xPos < 0 or xPos >= len(matrix) or yPos < 0 or yPos >= len(matrix[0]):
            return False
        
        # Get cell
        currCell = matrix[xPos][yPos]
        
        # If cell's value doesn't match with current letter, then exit function
        if currCell != word[wordPos]:
            return False
        
        # Update cell's value
        matrix[xPos][yPos] = ""
        
        # Check all directions
        right = self.traverseMatrix(matrix, xPos, yPos + 1, word, wordPos + 1) # right
        down = self.traverseMatrix(matrix, xPos + 1, yPos, word, wordPos + 1) # down
        left = self.traverseMatrix(matrix, xPos, yPos - 1, word, wordPos + 1) # left
        up = self.traverseMatrix(matrix, xPos - 1, yPos, word, wordPos + 1) # up
        
        # Change cell's value to its original value
        matrix[xPos][yPos] = currCell
        
        # If either variables are true, return true
        return right or down or left or up
    
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        
        # If board is a NoneType, exit function
        if board is None:
            return
        
        # Get board's dimensions
        m = len(board)
        n = len(board[0])
        
        # Iterate board
        for xPos in range(m):
            for yPos in range(n):
                    
                # If cell's value equals to first letter of the word, then start start search from here
                if board[xPos][yPos] == word[0]:
                    
                    # Traverse matrix from current point
                    if self.traverseMatrix(board, xPos, yPos, word, 0):
                        return True
                    
        # Return false by default
        return False
