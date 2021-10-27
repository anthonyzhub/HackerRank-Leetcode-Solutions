# https://leetcode.com/problems/unique-binary-search-trees/submissions/

class Solution:
    
    def recursiveCall(self, startPtr, endPtr, maxNumOfNodes, memoization):
        
        # If pointers go out-of-bounds, then only 1 node tree is possible
        if startPtr < 1 or endPtr > maxNumOfNodes:
            return 1
        
        # If pointers overlap, then only 1 node tree is possible
        if startPtr >= endPtr:
            return 1
        
        # If number of combinations were already calculated, return value and exit function
        if (startPtr, endPtr) in memoization.keys():
            return memoization[(startPtr, endPtr)]
        
        # Count how many trees will exist
        numOfTrees = 0
        
        # Iterate all possible combinations
        for idx in range(startPtr, endPtr + 1): # <= NOTE: Entered "+1" because range() function is [)
            
            # Check all possible combinations on both sides
            leftSide = self.recursiveCall(startPtr, idx - 1, maxNumOfNodes, memoization)
            rightSide = self.recursiveCall(idx + 1, endPtr, maxNumOfNodes, memoization)
    
            # Update counter
            numOfTrees += (leftSide * rightSide)
            
        # Add new combination to list
        memoization[(startPtr, endPtr)] = numOfTrees
        
        # Return counter
        return numOfTrees
    
    def numTrees(self, n: int) -> int:
        
        # NOTE: BST property is: left node < root < right node
        
        # If n equals 1, return 1
        if n == 1:
            return 1
        
        # Create a dictionary for memoization
        memoization = dict()
        
        # Calculate all possible combinations
        return self.recursiveCall(1, n, n, memoization)
