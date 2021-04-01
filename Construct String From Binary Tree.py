# Link: https://leetcode.com/problems/construct-string-from-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def tree2str(self, t: TreeNode) -> str:
        
        # NOTE: Each child must be surrounded by its own parentheses
        # E.g. 1 (2 (3) ) <= 1 is the parent, 2 is the child, 3 is the child's child
        
        # If t is NoneType, return empty string
        if t == None:
            return ""
        
        # If neither child exist, return its own value
        if t.left == None and t.right == None:
            return "{}".format(t.val)
        
        # If left child only exist, make a recursive call
        if t.left != None and t.right == None:
            return "{}({})".format(t.val, self.tree2str(t.left))
        
        # If both children exist, make a recursive call
        return "{}({})({})".format(t.val, self.tree2str(t.left), self.tree2str(t.right))
