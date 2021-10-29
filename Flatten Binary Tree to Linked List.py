# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
            
    def preorder(self, root, nodesVisited):
        
        # If root is empty, exit function
        if root is None:
            return
        
        # Add root to list and continue to visit other children
        nodesVisited.append(root)
        self.preorder(root.left, nodesVisited)
        self.preorder(root.right, nodesVisited)
        
    def flatten(self, root: Optional[TreeNode]) -> None:
        
        # NOTE: preorder is root, left, right
        
        # If root is None, exit function
        if root is None:
            return
        
        # If root doesn't have any children, exit function
        if root.right is None and root.left is None:
            return
        
        # Create a list and traverse tree in preorder
        nodesVisited = list()
        self.preorder(root, nodesVisited)
        
        # Iterate list
        # NOTE: Added "-1" because last node is a leaf node and doesn't have any children
        for idx in range(len(nodesVisited) - 1):
            
            # Get current node
            node = nodesVisited[idx]
            
            # Set right child as the next node and close left connection
            node.right = nodesVisited[idx + 1]
            node.left = None
        
        return root
