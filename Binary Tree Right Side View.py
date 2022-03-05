# https://leetcode.com/problems/binary-tree-right-side-view/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def traverseTree(self, root, log, curDepth):
        
        # If root is empty, exit function
        if root is None:
            return
        
        # Go to most-recent level then add node's value to list
        if len(log) == curDepth:
            log.append(root.val)
          
        # IMPORTANT: First traverse tree on the right side, then on the left side
        self.traverseTree(root.right, log, curDepth + 1)
        self.traverseTree(root.left, log, curDepth + 1)
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        # Create a list
        log = list()
        
        # Traverse tree
        self.traverseTree(root, log, 0)
        return log
