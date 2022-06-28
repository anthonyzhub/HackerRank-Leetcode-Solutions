# https://leetcode.com/problems/binary-tree-postorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def postorder(self, root, nodes):
        
        # If root is empty, exit function
        if root is None:
            return
        
        # Visit children
        self.postorder(root.left, nodes)
        self.postorder(root.right, nodes)
        
        # Add root to list
        nodes.append(root.val)
    
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        # OBJECTIVE: Traverse tree in postorder order (left, right, root)
        
        # If root is empty, return an empty list
        if root is None:
            return list()
        
        # Create a list
        nodes = list()
        
        # Traverse tree
        self.postorder(root, nodes)
        return nodes
