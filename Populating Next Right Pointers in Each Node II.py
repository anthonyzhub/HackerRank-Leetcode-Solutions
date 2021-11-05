# https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        # If root is empty, exit function
        if root is None:
            return root
        
        # If root is by itself, return itself
        if root.left is None and root.right is None:
            return root
        
        # Create a queue to hold nodes
        queue = [root]
        
        # Iterate queue
        while len(queue) != 0:
            
            # Create a list to hold all nodes on the same level
            nodesOnLevel = list()
            
            # Iterate queue
            print()
            for idx in range(len(queue)):
                
                # Get current node
                # currNode = queue[idx]
                currNode = queue.pop(0)
                print(currNode.val)
                
                # Save currNode's children to nodesOnLevel
                if currNode.left:
                    nodesOnLevel.append(currNode.left)
                    print(currNode.left.val)
                    
                if currNode.right:
                    nodesOnLevel.append(currNode.right)
                    print(currNode.right.val)
                    
                # Check if there's a neighboring node
                if len(queue) > 0:
                    
                    # Get next node
                    nextNode = queue.pop(0)
                    
                    # Connect both nodes and re-insert nextNode to queue
                    currNode.next = nextNode
                    queue.insert(0, nextNode)
                    
                else:
                    
                    currNode.next = None
                    
            # Add children to queue
            if len(nodesOnLevel) > 0:
                for child in nodesOnLevel:
                    queue.append(child)
                    
        return root
