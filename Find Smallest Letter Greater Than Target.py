# https://leetcode.com/problems/find-smallest-letter-greater-than-target/

from bisect import bisect

class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        
        # If list is empty, exit function
        if letters is None:
            return
        
        # Use bisect() to get index of where target should be inserted
        """NOTE: bisect() returns an index + 1 of an element that is smaller than target. The index after the small element features an element that is larger
                    than target, so target will fit right inbetween them"""
        
        idx = bisect(letters, target)
        
        # Modulo is used in case bisect() suggests to insert target after the last element. If that's the case, return 0
        return letters[idx % len(letters)]
