# Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        letterDict = dict()
        currLength = 0
        substringLen = 0
        longestLen = 0
        
        # Iterate string
        for pos, letter in enumerate(s):
        
            # Check if key exists and if it's position is greater than current length
            if (letter in letterDict) and (letterDict[letter] >= currLength):
                
                # Update starting point and substringLen
                currLength = letterDict[letter] + 1
                
                # Get difference between current position and last known position of letter
                substringLen = pos - letterDict[letter]
                
                # Update key's value to new positioning
                letterDict[letter] = pos
                
            else:
                
                # Add new pair and update length
                letterDict[letter] = pos
                substringLen += 1
                
                # Update longestLen
                if substringLen > longestLen:
                    longestLen = substringLen
                    
        # Return longest length
        return longestLen
                
                
                