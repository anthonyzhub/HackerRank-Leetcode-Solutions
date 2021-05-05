# Link: https://leetcode.com/problems/simplify-path/submissions/

class Solution(object):
    
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        
        # If string is empty, exit function
        if path is None or path == "":
            return
        
        # Create a stack
        stack = list()
        
        # Iterate string and parse it with "/" as delimiter
        for p in path.split("/"):
            
            # If p equals to ".." and stack isn't empty, pop last element
            if p == "..":
                if len(stack) != 0:
                    stack.pop()
                    
            # If p is anything, but a ".", add it to stack
            elif p and p != '.':
                stack.append(p)
        
        # Insert "/" at the beginning
        stack.insert("/", 0)
        
        # Return stack as a string
        return "/".join(stack)
