# https://leetcode.com/problems/climbing-stairs/

class Solution:
    
    def climbStairs(self, n: int) -> int:
        
        """
        OBJECTIVE: You are climbing a staircase. It takes n steps to reach the top. Each time you can either
                    climb 1 or 2 steps. In how many distinct ways can you climb to the top?
        
        Time Complexity: O(n) where n = the input n. The for-loop is iterating from n - 2 times. The " - 2" is
                        dropped because it is a constant.
        
        Space Complexity: O(n) where n = the size of stairs' list. The list will hold n elements.
        """
        
        # Create a list
        stairs = [1, 2]
        
        # Iterate range
        # NOTE: I started at 2 since the first 2 steps were already calculated
        for step in range(2, n):
            stairs.append(stairs[step - 2] + stairs[step - 1])
        
        return stairs[n - 1]
