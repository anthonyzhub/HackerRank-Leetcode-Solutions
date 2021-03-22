# Link: https://leetcode.com/problems/same-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def bfs(self, p: TreeNode, q: TreeNode):
        
        # If either is a NoneType, return false
        if (p != None and q == None) or (p == None and q != None):
            return False
        
        # If both are none, return true
        if p == None and q == None:
            return True
        
        # Return false, if both nodes don't share the same value
        if p.val != q.val:
            return False
        
        # Check all children
        leftChildCheck = self.bfs(p.left, q.left)
        rightChildCheck = self.bfs(p.right, q.right)
        
        # If either variable is false, return false
        if leftChildCheck == False or rightChildCheck == False:
            return False
        
        return True
    
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        
        return self.bfs(p, q)
