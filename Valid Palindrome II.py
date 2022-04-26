# https://leetcode.com/problems/valid-palindrome-ii/

class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        # If "s" is 1 letter long, return true
        if len(s) == 1:
            return True
        
        # Create pointers
        frontPtr = 0
        backPtr = len(s) - 1
        
        # Traverse string
        while frontPtr < backPtr:
            
            # If both letters match, move to next iteration
            if s[frontPtr] == s[backPtr]:
                frontPtr += 1
                backPtr -= 1
                continue
            
            # If both letters don't match, then parse string
            # NOTE: Only 1 letter be dropped at most. If the substring isn't a palindrome after skipping 1 letter, then
            #       entire string isn't a palindrome.
            #       Also, string slicing is [) where the last digit is non-inclusive.
            leftStr = s[frontPtr:backPtr]
            rightStr = s[frontPtr + 1:backPtr + 1]
            
            # Reverse both substrings
            if leftStr == leftStr[::-1] or rightStr == rightStr[::-1]:
                return True
            else:
                return False
        
        # If s is a palindrome, then program will exit while-loop.
        return True
