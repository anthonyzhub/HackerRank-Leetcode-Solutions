# https://leetcode.com/problems/sum-root-to-leaf-numbers/

from copy import deepcopy

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def preorder(self, root, tmpRoute, allRoutes):
        
        # If root is empty, exit function
        if root is None:
            return None
        
        # Check if root is a leaf node
        if root.left is None and root.right is None:
            
            tmpRoute += [root.val]
            allRoutes.append(deepcopy(tmpRoute))
            return
        
        # Visit children
        # NOTE: root.val wasn't added to tmpRoute because lists are passed by reference, so left child will appearing while inspecting right child subtree
        # I.e. Imagine the left sibling somehow being the child of its right brother
        self.preorder(root.left, tmpRoute + [root.val], allRoutes)
        self.preorder(root.right, tmpRoute + [root.val], allRoutes)
    
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        
        # If root is empty, exit function
        if root is None:
            return 0
        
        # If root doesn't have children, return root's value
        if root.left is None and root.right is None:
            return root.val
        
        # Create list to save routes
        allRoutes = list()
        self.preorder(root, [], allRoutes)
        print(allRoutes)
        
        # Iterate all possible routes
        total = 0
        for tmpList in allRoutes:
            
            # Change list to string
            tmpStr = ''.join(str(i) for i in tmpList)
            
            # Add number to total
            total += int(tmpStr)
            
        return total
