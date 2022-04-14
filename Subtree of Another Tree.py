# https://leetcode.com/problems/subtree-of-another-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def compareTrees(self, root, subRoot):
        
        # If both roots are empty, return true
        if root is None and subRoot is None:
            return True
        
        # If either roots are empty, return false
        if root is None or subRoot is None:
            return False
        
        # If both don't share the same value, return false
        if root.val != subRoot.val:
            return False
        
        # Inspect left and right subtrees of both roots
        leftSubTree = self.compareTrees(root.left, subRoot.left)
        rightSubTree = self.compareTrees(root.right, subRoot.right)
        
        # Return boolean statue of both variables
        # NOTE: subRoot's left and right subtrees MUST be inside of root
        return leftSubTree and rightSubTree
    
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        # If both roots are empty, return true
        if root is None and subRoot is None:
            return True
        
        # If only one root is empty, return false
        if root is None or subRoot is None:
            return False
        
        # If both trees are identical, return true
        if self.compareTrees(root, subRoot):
            return True
        
        # If condition above failed, then move to root's children
        # NOTE: The first condition assumes that root and subRoot share the same values. If not, then
        #       subRoot may start much lower in root.
        leftSubTree = self.isSubtree(root.left, subRoot)
        rightSubTree = self.isSubtree(root.right, subRoot)
        
        # NOTE: "or" was used because subtree may appear on left instead of right. Or vice versa.
        return leftSubTree or rightSubTree
