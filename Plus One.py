# Link: https://leetcode.com/problems/plus-one/submissions/

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        
        # Get size of list
        indx = len(digits) - 1
        
        # Iterate list in reverse
        for i in reversed(digits):
            
            # If true, change 9 to 0 and update index variable
            if i == 9:
                digits[indx] = 0
                indx -= 1
            else:
                digits[indx] += 1 # <= If 1 <= i <= 8, increment i and exit loop
                break
        
        # Check if list is filled with 0's
        # E.g. [0, 0, 0]
        if all(i == 0 for i in digits):
            digits.insert(0, 1)
        
        return digits
