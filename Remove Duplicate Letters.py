# https://leetcode.com/problems/remove-duplicate-letters/

class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        
        # If string is empty or only has 1 letter, return itself
        if len(s) <= 1:
            return s
        
        # Create a dictionary to hold letter and last recorded index
        last_occurrence = dict()
        
        # Create a stack and a set to hold characters
        stack = list()
        visited = set() # <= IMPORTANT: An element look up takes O(1) time. Faster than a list
        
        # Traverse word and save letter with its last recording index
        for i in range(len(s)):
            last_occurrence[s[i]] = i
        
        # Traverse word again and add letter to stack in lexicographical order
        for i in range(len(s)):
            
            # If letter wasn't visited before, add it
            if s[i] not in visited:
                
                # If last letter in stack is bigger than current letter, pop it because it needs to be in lexicographical order
                while stack and stack[-1] > s[i] and last_occurrence[stack[-1]] > i:
                    visited.remove(stack.pop(-1))
                    
                # Add current letter to stack and visited set
                stack.append(s[i])
                visited.add(s[i])
                
        return "".join(stack)
