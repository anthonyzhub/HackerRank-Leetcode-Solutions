# https://leetcode.com/problems/kth-smallest-element-in-a-bst/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def traverseTree(self, root, kElems, k):
        
        # If root is none, exit function
        if root is None:
            return
        
        # If list is already at max size K and root's value is smaller than largest number, replace largest number with root's value
        if len(kElems) == k and kElems[-1] > root.val:
            kElems.pop(-1)
            
        # Add root's value to list
        kElems.append(root.val)
        kElems.sort()
        
        # Traverse tree
        self.traverseTree(root.left, kElems, k)
        self.traverseTree(root.right, kElems, k)
    
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        # If root doesn't have any children, exit function
        if root.left is None and root.right is None:
            return root.val
        
        # Create a list
        kElems = list()
        
        # Traverse tree
        self.traverseTree(root, kElems, k)
        
        # Return largest number (last element) from list
        return kElems[k-1]
