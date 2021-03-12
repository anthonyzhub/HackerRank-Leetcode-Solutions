# Link: https://leetcode.com/problems/implement-strstr/submissions/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        # Base cases: 
        
        # Return 0 if both strings are empty
        if len(haystack) == 0 and len(needle) == 0:
            return 0
        
        # Return 0 if needle is empty
        if len(needle) == 0 and len(haystack) != 0:
            return 0
        
        # Return -1 if haystack is empty
        if len(haystack) == 0 and len(needle) != 0:
            return -1
        
        # Return if needle is not inside the haystack
        if needle not in haystack:
            return -1
        
        # Get length of needle
        needleLen = len(needle)
        
        # Iterate string
        for i in range(len(haystack)):
            
            # Slice string from current index to nth index
            if haystack[i:i + needleLen] == needle:
                return i
                
        return -1
