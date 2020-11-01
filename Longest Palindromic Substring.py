# Link: https://leetcode.com/problems/longest-palindromic-substring/submissions/

class Solution:
    
    def movePointers(self, leftPointer, rightPointer, s):
        
        # Move from left and right side
        while leftPointer >= 0 and rightPointer < len(s):
            
            # Check if elements at both positions match
            if s[leftPointer] == s[rightPointer]:
            
                # Move pointers. This will check if insides also match. 
                # Ex. abba => bb
                leftPointer -= 1
                rightPointer += 1
                
            else:
                break
                
        # Return substring.
        # NOTE: leftPointer could be -1, so add 1 to start at 0
        return s[leftPointer+1:rightPointer]
    
    def longestPalindrome(self, s: str) -> str:
        
        # Base case: If entire string is pandolimic return it
        if s == reversed(s):
            return s
        
        longestStr = ""
        for i in range(len(s)):
            
            # Check current position
            tmp = self.movePointers(i, i, s) # Ex. Input: "ab". Output "a"
            if len(tmp) >= len(longestStr):
                longestStr = tmp
                
            # Check next position
            tmp = self.movePointers(i, i+1, s) # Move from insde out
            if len(tmp) >= len(longestStr):
                longestStr = tmp
                
        return longestStr