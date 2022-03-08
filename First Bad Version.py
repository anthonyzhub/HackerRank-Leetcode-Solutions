# https://leetcode.com/problems/first-bad-version/

# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        
        # Create left and right pointers
        leftPtr = 1
        rightPtr = n
        
        # Stop while-loop if pointers overlap
        while rightPtr >= leftPtr:
            
            # Get middle version number
            midPtr = leftPtr + (rightPtr - leftPtr) // 2
            
            # Check if middle version is bad
            if isBadVersion(midPtr):
                
                # If true, move rightPtr to one unit before midPtr
                rightPtr = midPtr - 1
                continue
                
            else:
                
                # If false, move leftPtr to one unit after midPtr
                leftPtr = midPtr + 1
                
        # Return 1st bad version
        return leftPtr
