# Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def bstToGst(self, root: TreeNode) -> TreeNode:
        
        total = 0
        
        # Define a function for traversing
        def adding(currNode):
            
            # Override "total" from outside function
            nonlocal total
            if currNode == None:
                return
            
            # Traverse right side
            adding(currNode.right)
            
            # Update total and save value to current node to save time
            total += currNode.val
            currNode.val = total
            
            # Traverse left side
            adding(currNode.left)
            
        adding(root)
        return root
            
        
            
