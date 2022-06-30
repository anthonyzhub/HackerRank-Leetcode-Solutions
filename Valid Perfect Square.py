# https://leetcode.com/problems/valid-perfect-square/

class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        
        # Iterate range.
        # NOTE: +1 was added because last number is excluded
        for i in range(1, num + 1):
            
            # Check that i times itself equals to num
            if i**2 == num:
                return True
            
            # If output passes num, then don't continue
            # E.g., num=7 => 2*2=4 => 3*3=9 exit
            elif i**2 > num:
                return False
