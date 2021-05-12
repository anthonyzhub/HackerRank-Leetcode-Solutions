# Link: https://leetcode.com/problems/combinations/submissions/

from itertools import combinations

class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        
        # Create a list of numbers ranging from [1, n]
        # NOTE: [] means inclusive
        rangeList = list()
        for i in xrange(1, n + 1):
            rangeList.append(i)
        
        # Call combinations() and change output to a list by using map()
        return map(list, combinations(rangeList, k))
