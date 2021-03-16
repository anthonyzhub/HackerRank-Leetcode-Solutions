# Link: https://leetcode.com/problems/zigzag-conversion/solution/

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        # If s and numRows are equal to 1, return string
        if numRows == 1:
            return s
        
        if len(s) == 1:
            return s
        
        # Create string for answer
        ans = ""
        
        # Where characters in row 0 are located in the string
        cycle = 2 * numRows - 2
        
        # Iterate range
        for i in range(numRows):
            
            # Iterate string
            j = 0
            while j + i < len(s):
                
                # Add current characters to string
                ans += s[j + i]
                
                # Check if iterator is in between the 1st and last row
                if i != 0 and i != numRows - 1 and j + cycle - i < len(s):
                    ans += s[j + cycle -i] # <= Add character to specific row
                    
                # Update iterator
                j += cycle
                    
        return ans
