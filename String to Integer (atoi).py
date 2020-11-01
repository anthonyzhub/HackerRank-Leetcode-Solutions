# Link: https://leetcode.com/problems/string-to-integer-atoi/submissions/

class Solution:
    def myAtoi(self, s: str) -> int:
        
        # Remove all whitespaces
        s = s.strip()
        if s == "":
            return 0
        
        # Base case: If string starts with an alpha character, return 0
        if s[0].isalpha():
            return 0
        
        # Define MAX and MIN size
        MAX = 2**31 - 1
        MIN = -2 ** 31
        
        # Determine number sign.
        # Shorten string for for-loop ahead
        isNumberNegative = False
        if s[0] == "-":
            s = s[1:]
            isNumberNegative = True
        elif s[0] == "+":
            s = s[1:]
        
        # Iterate string
        num = ""
        for c in s:
            
            # Exit if a letter or a special character appears
            # Ex. A, B, or .
            if not c.isnumeric():
                break
            
            num += c
            
        # Exit if no numbers were added
        if num == None or num == "":
            return 0
        
        # str to int
        num = int(num)
        
        # Add numeric sign
        if isNumberNegative:
            num = -1 * num
        
        # Check if num exceeds max and min size
        if num > MAX:
            return MAX
        elif num < MIN:
            return MIN
        else:
            return num
