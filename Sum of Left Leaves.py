# https://leetcode.com/problems/sum-of-left-leaves/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def traverseTree(self, root, isLeftChild, leftLeavesSum):
        
        # If root is None, exit function
        if root is None:
            return leftLeavesSum
        
        # If root is a left LEAF node, add its value to leftLeavesSum
        if isLeftChild and root.left is None and root.right is None:
            leftLeavesSum += root.val
            
        # Visit root's children
        leftLeavesSum = self.traverseTree(root.left, True, leftLeavesSum)
        leftLeavesSum = self.traverseTree(root.right, False, leftLeavesSum)
        
        return leftLeavesSum
    
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        
        """
            OBJECTIVE: Compute the sum of ALL the left LEAF nodes. A node is a left leaf if it's a left child and has no children
            
            Time Complexity: O(n) where n = number of nodes inside of the binary tree. traverseTree() is visits all existing nodes.
            
            Space Complexity: O(1) because no dynamic data structures were created.
        """
        
        # If root is empty or by itself, exit function
        if root is None or (root.left is None and root.right is None):
            return 0
        
        # Create variable to hold sum of left leaves
        leftLeavesSum = 0
        
        # Traverse tree
        leftLeavesSum = self.traverseTree(root, False, leftLeavesSum)
        return leftLeavesSum
