# https://leetcode.com/problems/assign-cookies/

class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        
        """
        g[] => Each element represents a child and how much of a cookie they need to be satisfied
        s[] => Each element represents a cookie and how big they are
        """
        
        # Sort both lists (order doesn't matter in this question)
        g.sort()
        s.sort()
        
        # Create a variable to hold number of satisfied eaters
        satisfied = 0
        
        # Iterate cookies list
        for idx in range(len(s)):
            
            # If there aren't any more kids, exit
            if satisfied >= len(g):
                break
            
            # If kid can be fed with current cookie, increment counter
            if s[idx] >= g[satisfied]:
                satisfied += 1
                
        # Return total of satisfied eaters
        # NOTE: "satisfied" doesn't have to reach end of list. If not, then other kids won't get to eat a cookie
        return satisfied
