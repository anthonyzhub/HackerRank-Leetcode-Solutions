# https://leetcode.com/problems/interleaving-string/submissions/

class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        
        def iterateStrings(s1_idx, s2_idx, s3_idx):
            
            # If combination was already checked, return its value
            if (s1_idx, s2_idx, s3_idx) in memoization:
                return memoization[(s1_idx, s2_idx, s3_idx)]
            
            # If iterators reached the end of all strings, then return true
            if s1_idx == s1_size and s2_idx == s2_size and s3_idx == s3_idx:
                return True
            
            # If s1 iterator can move and letter matches in both strings, move s1 and s3 iterators
            s1_route = False
            if s1_idx < s1_size and s1[s1_idx] == s3[s3_idx]:
                s1_route = iterateStrings(s1_idx + 1, s2_idx, s3_idx + 1)
              
            # If s2 iterator can move and letter matches in both strings, move s2 and s3 iterators
            s2_route = False
            if s2_idx < s2_size and s2[s2_idx] == s3[s3_idx]:
                s2_route = iterateStrings(s1_idx, s2_idx + 1, s3_idx + 1)
                
            # Add result of pair to dictionary
            memoization[(s1_idx, s2_idx, s3_idx)] = s1_route or s2_route
            
            # Return route outcome
            # I.e. Is it possible to construct s3 based on s1 or s2 routes
            return s1_route or s2_route
            
        
        # Get length of all strings
        s1_size = len(s1)
        s2_size = len(s2)
        s3_size = len(s3)
        
        # Since s3 is an interleaving string of s1 and s2, if size doesn't match then exit function
        if s3_size != s1_size + s2_size:
            return False
        
        # Create a dictionary for memoization because we're going to lookup pairs
        memoization = dict()
        
        return iterateStrings(0, 0, 0)
