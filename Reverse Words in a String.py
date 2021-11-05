# https://leetcode.com/problems/reverse-words-in-a-string

class Solution:
    def reverseWords(self, s: str) -> str:
        
        # If s only has 1 letter, return it
        if len(s) == 1 and s[0].isalpha():
            return s
        
        # Remove leading and trailing whitespace
        s = s.strip()
        
        # Create 2 strings
        ansStr = ""
        tmpStr = ""
        
        # Iterate string
        for idx, character in enumerate(s):
            
            # Check if character is a whitespace
            if character == " ":
                
                # If next character is a whitespace, don't add tmpStr to ansStr and skip to next iteration
                if s[idx + 1] == " ":
                    continue
                
                # Add word from tmpStr to ansStr
                ansStr = tmpStr + character + ansStr
                tmpStr = ""
                
                # Skip to next iteration
                continue
                
            # Add character to tmpStr
            tmpStr += character
            
        # Add last remaining word to ansStr
        ansStr = tmpStr + " " + ansStr
        
        # Remove trailing whitespace from ansStr
        return ansStr[:-1]
