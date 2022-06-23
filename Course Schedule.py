# https://leetcode.com/problems/course-schedule/

from collections import defaultdict

class Solution:
    
    def bfs(self, startingNode, graph, queue):
        
        # OBJECTIVE: Use bfs() to find out if a cycle exists among the graph
        
        # Create a set for all courses that were taken
        visited = set()
        
        # Iterate queue
        while queue:
            
            # Pop node from queue and save it to visited set
            poppedNode = queue.pop()
            visited.add(poppedNode)
        
            # Check if node exist inside of graph
            if poppedNode in graph:
                
                # Get nodes close to poppedNode
                adjacentNodes = graph[poppedNode]
                
                # Iterate prerequisites list
                for adjNode in adjacentNodes:
                    
                    # If adjacent node is the starting node, then return false because it was already visited
                    # I.e., A cycle was detected, so return false
                    if adjNode == startingNode:
                        return False
                    
                    # If adjacent node wasn't visited before, save it to queue
                    if adjNode not in visited:
                        queue.append(adjNode)
        
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        """
        * OBJECTIVE: Return true if user can finish all courses inside of prerequisites
        *
        * Time Complexity: O(P + K*( V + E)) where P = length of prerequisites, K = length of graph, V + E = # of vertices and edges inside graph. 
        *
        *                   O(P) comes from the 1st for-loop where I add all elements from prerequisites[] to graph[]. 
        *
        *                   O(K * (V+E)) comes from the 2nd for-loop where I go through all the entries inside of the graph. Per entry, breadth-first search
        *                   is used to check if a cycle exists.
        *
        * Space Complexity: O(V + E) where V = # of vertices and E = # of edges. The graph will store all the prerequsiite courses as a key and link the course to take as values. 
        *                   Visited[] will hold all the vertices that I have visited inside the graph and queue[] will hold them temporarily until they're popped.
        """
        
        # Create a graph
        graph = defaultdict(list)
        
        # Add all items in prerequisites to graph
        for course in prerequisites:
            
            # Get course and its prerequisite
            node = course[0]
            adjNode = course[1]
            
            # Add data to graph
            graph[adjNode].append(node)
        
        # Iterate graph
        for node in graph:
            
            # Check if prerequisite courses overlap
            if self.bfs(node, graph, [node]) == False:
                return False
        
        return True
