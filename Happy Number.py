# https://leetcode.com/problems/happy-number/

class Solution:
    
    def sumAndSquareNumber(self, n):
        
        # OBJECTIVE: Square each digit in N and calculate digits' total sum
        
        # Convert n to a string
        n_str = str(n)

        # Iterate string
        final_num = 0
        for c in n_str:

            # Change string to int
            tmp_c = int(c) ** 2

            # Add to final_num
            final_num += tmp_c
            
        return final_num
    
    def isHappy(self, n: int) -> bool:

        # If n isn't a positive integer, immediately return false
        if n <= 0:
            return False
        
        # If n == 1, return true or else n will become 2 and so on
        if n == 1:
            return True

        # Create a list to hold all calculated numbers
        calculated_numbers = list()
        
        # While "n" (which will be updated inside loop as well) doesn't exist inside of list, continue to square and sum each digit
        while n not in calculated_numbers:
            
            # Add "n" to list for record keeping
            calculated_numbers.append(n)
            
            # Calculate new number
            n = self.sumAndSquareNumber(n)

            # If final_num equals to 1, then it's a happy number
            if n == 1:
                return True

        # If "n" already exist inside of list, return false to avoid repetition
        return False
