# Link: https://leetcode.com/problems/path-sum/submissions/

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    
    def traverse(self, root, currSum, targetSum):
        
        # If root is a NoneType, exit function
        if root is None:
            return False
        
        # Add root's value to currSum
        currSum += root.val
        
        # If root is actually a leaf and currSum equals to targetSum, return true
        if root.right is None and root.left is None and currSum == targetSum:
            return True
        
        # Visit children
        return self.traverse(root.left, currSum, targetSum) or self.traverse(root.right, currSum, targetSum)
    
    def hasPathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: bool
        """
        
        # If root is a NoneType, return false
        if root is None:
            return False
        
        return self.traverse(root, 0, targetSum)
        
