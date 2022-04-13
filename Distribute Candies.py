# https://leetcode.com/problems/distribute-candies/

from collections import Counter

class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        
        # If list is empty, exit function
        if candyType is None:
            return 0
        
        # If list only has 1 element, return 1
        if len(candyType) == 1:
            return 1
        
        # Convert list to dictionary
        candyTypeDict = Counter(candyType)
        
        # If n/2 candies is less than or equal to the number of different types of candy, then Alice can eat all the different types of candy
        if len(candyTypeDict.keys()) <= len(candyType) // 2:
            return len(candyTypeDict.keys())
        
        # If n/2 candies is greater than the number of different types of candy, then Alice can only eat n/2
        else:
            return len(candyType) // 2
