# Link: https://leetcode.com/problems/diameter-of-binary-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def nodeHeight(self, root):
        
        # Exit if root is NoneType
        if root == None:
            return 0
        
        # Get children's height
        leftChild = self.nodeHeight(root.left)
        rightChild = self.nodeHeight(root.right)
        
        # Return maximum height
        return 1 + max(leftChild, rightChild) # <= Added 1 because of current call
    
    def dfs(self, root):
        
        # Return 0, if root is NoneType
        if root == None:
            return 0
        
        # Get height of left and right side
        # NOTE: Used to calculate distance between nodes
        leftHeight = self.nodeHeight(root.left)
        rightHeight = self.nodeHeight(root.right)
        
        # Calculate diameter of both sides
        leftDiameter = self.dfs(root.left)
        rightDiameter = self.dfs(root.right)
        
        # Get maximum diameter
        maxDiameter = max(leftDiameter, rightDiameter)
        
        # Return maximum diameter (left side, right side, or left + right side)
        return max(leftHeight + rightHeight, maxDiameter)
        
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        
        """ There are 3 different solutions.
        1. If tree doesn't have any subtrees, then distance between leftmost and rightmost node is the diameter
        2. If tree does have a subtree on the left side, then distance between leftmost node and right node outside of the subtree
        3. Same as above, except the subtree is on the right side with the rightmost node
        """
        
        # Return 0, if root is by itself
        if root.left == None and root.right == None:
            return 0
        
        # Perform depth first search
        return self.dfs(root)
