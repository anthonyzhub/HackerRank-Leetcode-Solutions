# https://leetcode.com/problems/binary-tree-maximum-path-sum/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        """
        OBJECTIVE: Given the root of a binary tree, return the maximum path sum of any non-empty path.
        
        Time Complexity: O(n) where n = # of nodes inside the tree. dfs() will visit each node inside the tree and compute the maximum path sum.
        
        Space Complexity: O(h) where h = tree's height. dfs() is making recursive call per level. NOTE: If tree was equally balanced, space complexity would be O(log n) where n = # of nodes inside the tree.
        """
        
        # Create a list for future use
        res = [root.val]
        
        def dfs(root):
            
            # If root is none, exit function
            if root is None:
                return 0
            
            # Get maximum value from left and right children
            leftMax = dfs(root.left)
            rightMax = dfs(root.right)
            
            # If leftMax and rightMax are negative numbers, set them to 0
            leftMax = leftMax if leftMax > 0 else 0
            rightMax = rightMax if rightMax > 0 else 0
            
            # Set 0th element to maxmium value with split
            res[0] = max(res[0], root.val + leftMax + rightMax)
            
            return root.val + max(leftMax, rightMax)
        
        dfs(root)
        return res[0]
