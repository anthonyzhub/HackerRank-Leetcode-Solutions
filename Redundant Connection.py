# https://leetcode.com/problems/redundant-connection/

from collections import defaultdict

class Solution:
    
    def dfs(self, graph, start, end, visited):
        
        # OBJECTIVE: Use depth-first search to find out if start and end nodes are connected to each other
        
        if start not in visited:
            
            # Add start node to set
            visited.add(start)
            
            # If start node equals to end, return true
            if start == end:
                return True
            
            # If not, visit start's neighboring nodes
            results = list()
            for neighbor in graph[start]:
                
                # Capture any output given by dfs()
                results.append(self.dfs(graph, neighbor, end, visited))
            
            # Use any() to return true if there's "True" exist inside of list
            return any(results)
    
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        """
        OBJECTIVE: Return an edge that can be removed so that the resulting graph is a tree of "n" nodes
        
        Time Complexity: O(N^2) where N = # of vertices and edges in the graph
        
        Space Complexity: O(N) where N = # of nodes inside the graph. The graph had to be constructed with N nodes
        """
        
        # Create a graph
        graph = defaultdict(set)
        
        # Iterate edges list
        for start, end in edges:
            
            # Create a set of visited nodes
            visited = set()
            
            # If start and end vertices exist inside graph and start and end are connected through an edge, return it
            if (start in graph and end in graph) and self.dfs(graph, start, end, visited):
                return [start, end]
            
            # Add start and end nodes to graph
            graph[start].add(end)
            graph[end].add(start)
