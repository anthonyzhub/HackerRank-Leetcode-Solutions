# Link: https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

import collections

class Solution:
    def maxFreq(self, s: str, maxLetters: int, minSize: int, maxSize: int) -> int:
        
        """
        maxLetters: # of unique characters
        minSize and maxSize: Size of substring
        """
        
        # Create a dictionary with default values
        wordDict = collections.defaultdict(int)
        
        # Iterate string
        for i in range(len(s)):
            
            # Iterate string from minSize position to maxSize position
            # NOTE: Program doesn't require that string's length must equl to either minSize or maxSize
            # Also, incase i + (maxSize - 1) is out of bounds, go up to Nth position
            for j in range(i + minSize - 1, min(i + maxSize, len(s))):
                
                # Create temporary string
                tmpStr = s[i:j+1]
                
                # If unique characters are met, add to dictionary or increment value
                # NOTE: Set doesn't allow duplicates
                if len(set(tmpStr)) <= maxLetters:
                    wordDict[tmpStr] += 1
                    
        # Return max value from dicitonary
        # If wordDict were to be empty, return 0 as default value
        return max(wordDict.values(), default=0)
