# https://leetcode.com/problems/factorial-trailing-zeroes/

class Solution:
    
    def factorial(self, num):
        if num == 0:
            return 1
        
        return num * self.factorial(num-1)
    
    def trailingZeroes(self, n: int) -> int:
    
        # Numbers below 5 don't have trailing zeroes
        if n <= 4:
            return 0
        
        # Compute factorial and convert it to a string
        answerStr = str(self.factorial(n))
        
        # Iterate string in reverse order
        zeroes = 0
        for elem in reversed(answerStr):
            
            # If "elem" is a zero, increment counter. If not, exit loop
            if elem == "0":
                zeroes += 1
            else:
                break
        
        # Return counter
        return zeroes
