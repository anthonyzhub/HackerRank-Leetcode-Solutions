class Solution:
    
    def climbStairs(self, n: int) -> int:
        
        # Create a list with a few added elements
        # E.g. 0 and 1 step = 1 unique path
        #       2 steps = 2 unique paths
        stepsNeeded = [1, 1]
        
        # Fill in list up to n
        for i in range(2, n+1): # <= "n+1" was added to make "n" inclusive
            
            # NOTE: The append function was used, instead of stepsNeeded[i], is because the latter caused an "index out of range" error.
            # This makes sense because position "i" never existed. If you want to have an "ith" position, then you need to APPEND the element to the list.
            stepsNeeded.append(stepsNeeded[i-1] + stepsNeeded[i-2])
            
        return stepsNeeded[n]
