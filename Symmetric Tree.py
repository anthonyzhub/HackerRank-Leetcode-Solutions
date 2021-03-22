# Link: https://leetcode.com/problems/symmetric-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def bfs(self, leftChild, rightChild):
        
        # Check if one node is NoneType
        if (leftChild == None and rightChild != None) or (leftChild != None and rightChild == None):
            return False
        
        # Check if both nodes are NoneType
        if leftChild == None and rightChild == None:
            return True
        
        # Check if both nodes share the same value
        if leftChild.val != rightChild.val:
            return False
        
        # Check if left and right nodes are the same
        leftAndRight = self.bfs(leftChild.right, rightChild.left)
        
        # Check if right and left nodes are the same
        rightAndLeft = self.bfs(leftChild.left, rightChild.right)
        
        # If either variables is False, return False
        if leftAndRight == False or rightAndLeft == False:
            return False
        
        return True
    
    def isSymmetric(self, root: TreeNode) -> bool:
        
        # Check if root is NoneType
        if root == None:
            return True
        
        # Check if root has any children
        if root.left == None and root.right == None:
            return True
        
        # Check if either children is missing
        if (root.left != None and root.right == None) or (root.left == None and root.right != None):
            return False
        
        return self.bfs(root.left, root.right)
