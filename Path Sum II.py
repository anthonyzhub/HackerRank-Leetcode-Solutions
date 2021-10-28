# https://leetcode.com/problems/path-sum-ii/submissions/

from copy import deepcopy

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def traverse(self, root, targetSum, currRoute, totalRoutes):
        
        # IF root is empty, exit function
        if root is None:
            return
        
        # Automatically deduct targetsum and add node to current route
        targetSum -= root.val
        currRoute.append(root.val)
        
        # If root is a leaf node and targetsum is 0, then save possible route
        # NOTE: For some reason, an error occurs when "return" is included to exit function
        if root.left is None and root.right is None and targetSum == 0:
            totalRoutes.append(deepcopy(currRoute))
            # return
        
        # Visit children
        self.traverse(root.left, targetSum, currRoute, totalRoutes)
        self.traverse(root.right, targetSum, currRoute, totalRoutes)
        
        # After visitng children, undo stack and remove node
        # E.g. [1, 2, 3] => [1, 2]
        currRoute.pop(-1)
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        # If root is empty, return empty list
        if root is None:
            return []
        
        # Check if root is by itself
        if root.left is None and root.right is None:
            
            # If root's value equals to targetsum, return root as a list
            if root.val == targetSum:
                return [[root.val]]
            
            # If not, return an empty list
            else:
                return []
        
        totalRoutes = list()
        self.traverse(root, targetSum, [], totalRoutes)
        
        return totalRoutes
