# https://leetcode.com/problems/cheapest-flights-within-k-stops/
# Reference: https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/2273652/Just-Dijkstra-Very-simple-and-efficient

import heapq

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        
        # Create a dictionary of adjacent nodes
        adj = {airport: list() for airport in range(n)}
        
        # Populate dictionary with flight information
        for curSrc, curDest, curCost in flights:
            adj[curSrc].append((curDest, curCost))
            
        # Create a heap
        minHeap = [(0, src, 0)]
        heapq.heapify(minHeap)
        
        # Create a list of visited nodes
        visited = [k + 1] * n
        
        # Iterate heap
        while minHeap:
            
            # Get cost, node, depth level from popped element
            cost, node, level = heappop(minHeap)
            
            # If node equals to dest, return cost
            if node == dst:
                return cost
            
            # If level is less than stops left or level is greater or equal to nth index in visited, skip to next loop
            if level > k or level >= visited[node]:
                continue
                
            # Update element at nth index in visited
            visited[node] = level
            
            # Add connecting flights from node to heap
            for curDest, curCost in adj[node]:
                heappush(minHeap, (cost + curCost, curDest, level + 1))
                
        return -1
