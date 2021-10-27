# https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        # inorder: left, root, right
        # postorder: left, right, root
        
        # If there aren't any more values to use, exit function
        if len(inorder) == 0:
            return None
        
        # Get last element in postorder because it will always be root
        # NOTE: Don't pop or an error will appear
        rootValue = postorder[-1]
        
        # Create root node
        root = TreeNode(rootValue)
        
        # Find root inside "inorder" to slice list
        # NOTE: A sliced list will actually split the list into left and right subtree
        inorderIdx = inorder.index(rootValue)
        
        # Make a recursive call for left and right subtree
        root.left = self.buildTree(inorder[:inorderIdx], postorder[:inorderIdx])
        root.right = self.buildTree(inorder[inorderIdx + 1:], postorder[inorderIdx: -1]) # <= Regarding latter, it will slice list from right to end and go back to the beginning. Think of it as a jump back to the beginning after reaching the end.
        
        # Return new node
        return root
