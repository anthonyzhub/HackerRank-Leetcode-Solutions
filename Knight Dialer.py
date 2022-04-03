# https://leetcode.com/problems/knight-dialer/

class Solution:
    
    def traverseMatrix(self, validJumps, jumpsLeft, numericCell, memo):
        
        # If jumpsLeft is 0, return 1 valid number
        if jumpsLeft == 0:
            return 1
        
        # If this cell was visited before, return its value
        if (jumpsLeft, numericCell) in memo:
            return memo[(jumpsLeft, numericCell)]
        
        # Cycle through dictionary of validJumps
        ans = 0
        for validCells in validJumps[numericCell]:
            ans += self.traverseMatrix(validJumps, jumpsLeft - 1, validCells, memo)
            
        # Save path to memo
        memo[(jumpsLeft, numericCell)] = ans
        
        return ans
    
    def knightDialer(self, n: int) -> int:
        
        # Create a dictionary
        # NOTE: {Numeric Cells: List of cells that can be jumped to}
        validJumps = {
            0: [4, 6],
            1: [8, 6],
            2: [7, 9],
            3: [4, 8],
            4: [0, 3, 9],
            5: [],
            6: [0, 1, 7],
            7: [2, 6],
            8: [1, 3],
            9: [2, 4]
        }
        
        # Create a dictionary for memoization
        memo = dict()
        
        # Start jumping from a new start point
        numOfCombos = 0
        for numericCell in range(10):
            numOfCombos += self.traverseMatrix(validJumps, n - 1, numericCell, memo)
            
        return numOfCombos % 1000000007
