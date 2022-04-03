# https://leetcode.com/problems/sum-of-two-integers/

class Solution:
    def getSum(self, a: int, b: int) -> int:
        
        # Find unicode for "+"
        plus_unicode = ord("+")
        
        # Convert unicode to char
        plus_char = chr(plus_unicode)
        
        # Use eval() to evaluate expression.
        # If expression can be executed, Python will do it
        return eval(f"{a}{plus_char}{b}")
