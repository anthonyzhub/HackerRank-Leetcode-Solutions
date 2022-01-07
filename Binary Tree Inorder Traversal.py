# https://leetcode.com/problems/binary-tree-inorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def traverseTree(self, root, log):
        
        # Exit if root is empty
        if root is None:
            return log
        
        # Visit left child
        if root.left:
            self.traverseTree(root.left, log)
    
        # Add root's value to log
        log.append(root.val)
        
        # Visit right child
        if root.right:
            self.traverseTree(root.right, log)
            
        # Return list
        return log
    
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        
        # In-order traversal is Left, Root, Right
        return self.traverseTree(root, [])
