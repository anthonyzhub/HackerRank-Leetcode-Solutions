# https://leetcode.com/problems/course-schedule-ii/
from collections import defaultdict

class Solution:
    
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # Create labels for nodes
        WHITE = 1
        GRAY = 2
        BLACK = 3
        
        # Create a dictionary holding adjaceny and dependent nodes
        adjacencyList = defaultdict(list)
        
        # Traverse matrix and add all nodes to the dictionary
        for node, adjNode in prerequisites:
            adjacencyList[adjNode].append(node)
        
        # Create a return list
        topological_sorted_order = list()
        is_possible = True
        
        # Create a dictionary where all nodes are marked white
        color = dict()
        for curNode in range(numCourses):
            color[curNode] = WHITE
            
        def dfs(node):
            
            # Use variable from root function
            nonlocal is_possible
            
            # If boolean variable is false, then cycle was detected
            if not is_possible:
                return
            
            # Start recursion
            color[node] = GRAY
            
            # Traverse on neighboring nodes
            if node in adjacencyList:
                
                for neighborNode in adjacencyList[node]:
                    
                    # If node is marked as WHITE, then it hasn't been visited yet so perform dfs() from there
                    if color[neighborNode] == WHITE:
                        dfs(neighborNode)
                        
                    # If node is marked as GRAY, then a cycle was detected
                    elif color[neighborNode] == GRAY:
                        is_possible = False
            
            # Mark node as BLACK when it's done being traversed
            color[node] = BLACK
            
            # Add finished node to list
            topological_sorted_order.append(node)
        
        # Iterate graph
        for node in range(numCourses):
            
            # If node is marked WHITE, traverse it
            if color[node] == WHITE:
                dfs(node)
        
        # If a cycle wasn't detected, return list in reverse order
        if is_possible:
            return topological_sorted_order[::-1]
        else:
            return list()
