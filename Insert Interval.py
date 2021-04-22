# Link: https://leetcode.com/problems/insert-interval/submissions/

class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        
        # If intervals is empty, return newInterval
        if len(intervals) == 0:
            return [newInterval]
        
        # Immediately add newInterval to intervals
        intervals.append(newInterval)
        
        # Sort list based on 1st element of each inner list
        intervals.sort(key=lambda x: x[0])
                
        # Create a new list to return
        ans = list()
        
        # Iterate intervals list and add non-overlapping elements to ans
        for interval in intervals:
            
            # If list is empty, add first element and skip to next iteration
            if len(ans) == 0:
                ans.append(interval)
                continue
            
            # Get recently added element from ans
            lastInterval = ans[-1]
                
            # If lastInterval and current interval doesn't overlap, merge both
            if lastInterval[1] < interval[0]:
                
                ans.append(interval)
                
            else:
                
                # Get smallest X-value and largest Y-value between both intervals
                smallX = min(lastInterval[0], interval[0])
                largeY = max(lastInterval[1], interval[1])
                
                # Replace last interval with merged one
                ans[-1] = [smallX, largeY]
        
        return ans
