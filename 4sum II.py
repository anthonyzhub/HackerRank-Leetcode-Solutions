# https://leetcode.com/problems/4sum-ii/

from collections import defaultdict

class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        
        # Create a dictionary
        dic = defaultdict(int)
        
        # Create a return variable
        res = 0
        
        # Store all possible combinations of nums1 and nums2 to dic
        for i in nums1:
            for j in nums2:
                
                # Store sum of i and j and it's frequency in dic
                dic[i + j] += 1
                
        # Create all possible combinations of nums3 and nums4
        for i in nums3:
            for j in nums4:
                
                # If there's a negation of (i+j) inside dic, add it's value to res
                # Remember, we're looking for how MANY tuples there are that sums to 0. 
                # E.g., If there's 2 pairs with each having a sum of 3 and another 2 pairs with each having a sum of -3, then there are a total of 4 pairs in which added together will equal to 0
                
                res += dic[-(i + j)]
                
        return res
