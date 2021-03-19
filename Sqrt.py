# Link: https://leetcode.com/problems/sqrtx/submissions/

from math import sqrt

class Solution:
    def mySqrt(self, x: int) -> int:
        
        # Find square root of number
        x = sqrt(x)
        
        # Turn integer to string
        x = str(x)
        
        # Add digits before decimal point to x
        ans = ""
        for i in x:
            if i == ".":
                break
            
            ans += i
            
        return ans
