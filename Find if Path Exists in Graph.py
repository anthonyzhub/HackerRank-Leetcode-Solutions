# https://leetcode.com/problems/find-if-path-exists-in-graph/

class Solution:
    
    def iterateDict(self, neighboringVertices, visitedVertices, source):
        
        # OBJECTIVE: Go through every vertex and its neighbors without visiting the same vertex
        
        # Add source to visitedVertices to avoid repetition
        visitedVertices.add(source)
        
        # Go through source's connecting vertices
        for curNeighbor in neighboringVertices[source]:
            
            # If neighbor hasn't already been visited, inspect its neighbors
            if curNeighbor not in visitedVertices:
                self.iterateDict(neighboringVertices, visitedVertices, curNeighbor)
    
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        
        # If matrix is empty, return true
        if len(edges) == 0:
            return True
    
        # Create a dictionary of vertex as key and its neighbors as values
        # E.g., Node: [node_1, node_2]
        neighboringVertices = dict()
        
        # Iterate matrix while populating dictionary
        for curVertex in edges:
            
            # Dissect curVertex for source and destination
            tmpSource = curVertex[0]
            tmpDest = curVertex[1]
            
            # If tmpSource doesn't exist inside dictionary, add it
            if tmpSource not in neighboringVertices:#.keys():
                neighboringVertices[tmpSource] = list()
            
            neighboringVertices[tmpSource].append(tmpDest)
                
            # Repeat code above for tmpDest
            if tmpDest not in neighboringVertices:#.keys():
                neighboringVertices[tmpDest] = list()
            
            neighboringVertices[tmpDest].append(tmpSource)
                
        # After adding all vertices to dictionary, iterate dictionary
        visitedVertices = set()
        self.iterateDict(neighboringVertices, visitedVertices, source)
        
        # If destination is inside of visitedVertices, then a path exist
        if destination in visitedVertices:
            return True
        
        return False
