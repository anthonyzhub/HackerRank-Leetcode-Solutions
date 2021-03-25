# Link: https://leetcode.com/problems/invert-binary-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        
        # If root is empty, exit function
        if root == None:
            return
        
        # Traverse left and right child
        leftChild = self.invertTree(root.left)
        rightChild = self.invertTree(root.right)
        
        # Swap nodes
        root.left = rightChild
        root.right = leftChild
        
        # Return root
        return root
        
