# https://leetcode.com/problems/min-stack/

import sys
class MinStack:

    def __init__(self):
        
        # Create a list
        self.stack = list()
        
        # Hold minimum value
        self.minElem = [sys.maxsize, -1]

    def push(self, val: int) -> None:
        
        # OBJECTIVE: Add new number to end of list and update minVal if possible
            
        # Add new value
        self.stack.append(val)
        
        # Update minVal
        if val <= self.minElem[0]:
            self.minElem = [val, len(self.stack) - 1]

    def pop(self) -> None:
        
        # OBJECTIVE: Remove last element from stack
        
        # Remove last value
        self.stack.pop(-1)
        
        # If stack is empty, reset minElem 
        if len(self.stack) == 0:
            self.minElem = [sys.maxsize, -1]
            
        # If stack is non-empty, check if minElem needs to be updated
        # E.g., The last element could have been the smallest one, so minElem needs to be updated
        elif self.minElem[1] >= len(self.stack) - 1:
            minVal = min(self.stack)
            self.minElem = [minVal, self.stack.index(minVal)]
        
    def top(self) -> int:
        
        # OBJECTIVE: Return last element from stack
        return self.stack[-1]

    def getMin(self) -> int:
        
        # OBJECTIVE: Return minimum element in stack
        return self.minElem[0]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
