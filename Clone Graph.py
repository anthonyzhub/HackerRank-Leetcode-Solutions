# https://leetcode.com/problems/clone-graph/

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    
    def dfs(self, node, memo):
        
        # Iterate node's neighbors list
        for neighbor in node.neighbors:
            
            # If node doesn't exist in memo, create a new pair
            if neighbor not in memo:
                
                # Save original and clone node to list
                memo[neighbor] = Node(neighbor.val)
                
                # Perform a dfs of neighbor's adjacent list
                self.dfs(neighbor, memo)
                
            # Add clone of neighbor to node's adjacent list
            memo[node].neighbors.append(memo[neighbor])
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        # If node is empty, return itself
        if node is None:
            return node
        
        # If node doesn't have any neighbors, return itself
        if len(node.neighbors) == 0:
            return Node(node.val)
        
        # Create a dictionary for memoizaiton
        memo = dict()
        
        # Create a new node and save new and old nodes to list
        # I.e. Save "node" as key and its clone as value
        memo[node] = Node(node.val)
        
        # Perform a DFS
        self.dfs(node, memo)
        
        # Return clone
        return memo[node]
