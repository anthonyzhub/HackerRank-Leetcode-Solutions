# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def recursiveCall(self, preorder, inorder):
        
        # NOTE: The 1st element in preorder will always be root
        #       When you find the root from preorder, you need to also find it in inorder because once found you can tell what elements
        #       are in the left and right subtree
        
        # If there aren't any more elements, exit function
        # NOTE: I think "inorder" was used here because the last element will be a leaf on the far-right subtree
        if len(inorder) == 0:
            return None
        
        # Pop 1st element in preorder
        rootValue = preorder.pop(0)
        
        # Create a root node
        root = TreeNode(rootValue)
        
        # Find root in "inorder"
        inorderIdx = inorder.index(rootValue)
        
        # Get left and right subtree
        root.left = self.recursiveCall(preorder, inorder[:inorderIdx])
        root.right = self.recursiveCall(preorder, inorder[inorderIdx + 1:])
        
        # Return root node
        return root
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        # Preorder: root, left, right
        # Inorder: left, root, right
        
        # If both lists only have 1 element, return a single node
        if len(preorder) == 1 and len(inorder) == 1:
            return TreeNode(preorder[0])
        
        return self.recursiveCall(preorder, inorder)
