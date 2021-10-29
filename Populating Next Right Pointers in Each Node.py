# https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

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
    
    def dfs(self, currNode, root):
        
        # If node is empty, exit function
        if currNode is None:
            return
        
        # Connect child node to parent
        currNode.next = root
        
        # Connect left child with right child
        self.dfs(currNode.left, currNode.right)
        
        # If root is empty, connect right child to None
        if root is None:
            self.dfs(currNode.right, None)
            
        # If root isn't empty, connect right child to sibling (left child)
        else:
            self.dfs(currNode.right, root.left)
    
    def connect(self, root: 'Node') -> 'Node':
        
        # If root is none, return an empty list
        if root is None:
            return root
        
        # If root is by itself, return itself
        if root.left is None and root.right is None:
            return root
        
        # Traverse tree and return root
        self.dfs(root, None)
        return root
