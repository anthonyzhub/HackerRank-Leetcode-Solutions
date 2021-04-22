# Link: https://leetcode.com/problems/merge-intervals/submissions/

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        
        # If there's only one element inside of list, return itself
        if len(intervals) == 1:
            return intervals
        
        # Create a list to store non-overlapping intervals
        ans = list()
        
        # Sort list by ascending order of the 1st element of each element
        intervals.sort(key=lambda x: x[0])
        
        # Iterate list
        for i in intervals:
            
            # If ans is empty, append ith element
            if len(ans) == 0:
                ans.append(i)
                continue
                
            # Get last element inside ans
            lastInterval = ans[-1]
            
            # If last interval ends before current interval starts, append current interval
            # E.g. [1, 2] and [3, 4]
            if lastInterval[1] < i[0]:
                ans.append(i)
            else:
                
                # If y1 overlaps x2, merge both
                # E.g. [1, 2] and [2, 3] => [1, 3]
                largeY = max(lastInterval[1], i[1])
                ans[-1] = [lastInterval[0], largeY]
                
        return ans
