# https://leetcode.com/problems/ugly-number/

class Solution:
    
    def isUgly(self, n: int) -> bool:
        
        # If n is negative, return false
        if n < 0:
            return False
        
        # Continue to divide number until condition is false
        while n > 1:
            
            if n % 2 == 0:
                n /= 2
            
            elif n % 3 == 0:
                n /= 3
                
            elif n % 5 == 0:
                n /= 5
                
            else:
                return False
            
        # If n equals to 1, then n is an ugly number
        return n == 1
