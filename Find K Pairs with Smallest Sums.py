# https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

import heapq

class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        
        # Get size of each list
        m = len(nums1)
        n = len(nums2)
        
        # Create a return list
        res = list()
        
        # Create a set of visited index pairs
        visited = set()
        
        # Create a heap holding index pairs and its sum
        heap = [(nums1[0] + nums2[0], (0, 0))]
        
        # Iterate range of min value
        # NOTE: Sometimes k is smaller than m or n, so calculate the maximum number of possible combinations
        for _ in range(min(k, m*n)):
            
            # Pop first element from heap
            curSum, (idxA, idxB) = heappop(heap)
            
            # Add pair to res list
            res.append([nums1[idxA], nums2[idxB]])
            
            # Check if idxA + 1 doesn't go out of bounds and that the potential index pair wasn't visited before
            if idxA + 1 < m and (idxA + 1, idxB) not in visited:
                
                # Add new index pair to heap and visited set
                heappush(heap, (nums1[idxA + 1] + nums2[idxB], (idxA + 1, idxB)))
                visited.add((idxA + 1, idxB))
                
            # Check if idxB + 1 doesn't go out of bounds and that the potential index pair wasn't visited before
            if idxB + 1 < n and (idxA, idxB + 1) not in visited:
                
                # Add new index pair to heap and visited set
                heappush(heap, (nums1[idxA] + nums2[idxB + 1], (idxA, idxB + 1)))
                visited.add((idxA, idxB + 1))
                
        return res
