# https://leetcode.com/problems/find-smallest-letter-greater-than-target/

from bisect import bisect

class Solution:
    
    def binarySearch(self, letters, target, leftPtr, rightPtr):
            
        # Continue if pointers don't overlap
        if leftPtr <= rightPtr:
            
            # Create middle pointer
            midPtr = (leftPtr + rightPtr) // 2
            
            # If element at middle pointer is less than or equal to target, go to right-half of list
            if letters[midPtr] <= target:
                return self.binarySearch(letters, target, midPtr + 1, rightPtr)
            
            # If element at middle pointer greater than target, go to left-half of list
            elif letters[midPtr] > target:
                return self.binarySearch(letters, target, leftPtr, midPtr - 1)
            
        return leftPtr
        
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        
        # SOLUTION #1
          
        # Get index of where target should be
        idx = self.binarySearch(letters, target, 0, len(letters) - 1)
        
        # Modulo is used in case binarySearch() suggests to insert target after the last element. If that's the case, return 0
        return letters[idx % len(letters)]
        
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        
        # SOLUTION #2
        
        # If list is empty, exit function
        if letters is None:
            return
        
        # Use bisect() to get index of where target should be inserted
        """NOTE: bisect() returns an index + 1 of an element that is smaller than target. The index after the small element features an element that is larger
                    than target, so target will fit right inbetween them"""
        
        idx = bisect(letters, target)
        
        # Modulo is used in case bisect() suggests to insert target after the last element. If that's the case, return 0
        return letters[idx % len(letters)]
