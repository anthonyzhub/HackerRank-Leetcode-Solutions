# Link: https://leetcode.com/problems/all-paths-from-source-to-target/submissions/

class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        # graph is a matrix with consecutive, sorted elements. 
        # The length of the graph will also be the largest element
        endpoint = len(graph) - 1
        
        # Create a list to save path travelled
        travelledPath = list()
                
        # Define function to go through matrix
        def traverse(node, currPath, travelledPath):
            
            # If true, then this is the end of the path
            if node == endpoint:
                travelledPath.append(currPath)
                
            # Go through matrix again from a different starting point
            for nextNode in graph[node]:
                
                # NOTE: Temporary create a list for next node and merge it with previously visited path
                traverse(nextNode, currPath + [nextNode], travelledPath)
                
        # Traverse matrix from starting point
        # NOTE: Since starting point is always 0, add it to list
        traverse(0, [0], travelledPath)
        return travelledPath
