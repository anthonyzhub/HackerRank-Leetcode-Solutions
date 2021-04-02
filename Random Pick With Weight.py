# Link: https://leetcode.com/problems/random-pick-with-weight/submissions/

from random import random

# OBJECTIVE: Turn w into a previously sum list
# E.g. ith element = sum of w[:i-1] and w[i]

class Solution:

    def __init__(self, w: List[int]):
        
        # Create a new list to hold sum of previous elements
        prevSum = 0
        self.previousSumList = list()
        
        for i in w:
            self.previousSumList.append(prevSum + i)
            prevSum += i
            
        # Save entire sum of list
        self.total = prevSum

    def pickIndex(self) -> int:
        
        if len(self.previousSumList) == 1:
            return 0
        
        # Get random number to find inside list
        targetElem = self.total * random()
        
        for idx, elem in enumerate(self.previousSumList):
            
            if targetElem < elem:
                return idx

# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()
