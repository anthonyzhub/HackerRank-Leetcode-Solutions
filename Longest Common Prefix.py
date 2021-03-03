# Link: https://leetcode.com/problems/longest-common-prefix/submissions/

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        # Create answer variable
        longestCommonPrefix = ""
        
        # Base case: If strs is empty
        if len(strs) <= 0:
            return ""
        
        # Get first word from string
        firstWord = strs[0]
        
        # Iterate first word
        index = 0
        for c in firstWord:
            
            # Iterate list from 2nd position to last
            for word in strs[1:]:
                
                # STOP, if (1) firstWord's length is greater than current word. Or,
                # (2) if both letters doesn't match
                if index >= len(word) or c != word[index]:
                    return longestCommonPrefix
                
            # Increment index and update answer
            index += 1
            longestCommonPrefix += c
            
        # Added because input could feature an empty string.
        return longestCommonPrefix
