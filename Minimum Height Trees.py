# https://leetcode.com/problems/minimum-height-trees/

class Solution:
    
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        
        # If n is less than or equal to 2, return elements from the list.
        # NOTE: This tree will have centroids (nodes at the center) and centroids will always have the shortest tree height
        if n <= 2:
            return [elem for elem in range(n)]
        
        # If n equals 1, return first and only element in edges
        if n == 1:
            return list(edges[0][0])
        
        # Iterate edges list
        graph = defaultdict(set)
        for pair in edges:
            
            # Break down pair
            vertexA = pair[0]
            vertexB = pair[1]
            
            # Add vertex dictionary
            graph[vertexA].add(vertexB)
            graph[vertexB].add(vertexA)
            
        # Create a list to hold leaf nodes
        leaves = list()
        
        # Iterate graph and collect nodes that are leaf nodes
        for i in range(n):
            if len(graph[i]) == 1:
                leaves.append(i)
                
        # Trim the leaves until reaching the centroids
        remainingNodes = n
        while remainingNodes > 2:
            
            # Remove leaves from remainingNodes
            remainingNodes -= len(leaves)
            
            # Create a list to hold new leaves
            newLeaves = list()
            
            # Remove current leaves
            while leaves:
                
                # Pop first node
                leaf = leaves.pop()
                
                # Remove the only neighor left of the leaf node
                neighbor = graph[leaf].pop()
                
                # Remove the only edge node left
                graph[neighbor].remove(leaf)
                
                # If neighbor suddenly becomes a leaf node, add it to newLeaves
                if len(graph[neighbor]) == 1:
                    newLeaves.append(neighbor)
                    
            # Update leaves with newLeaves
            leaves = newLeaves
            
        # Return graph's centroids
        return leaves
