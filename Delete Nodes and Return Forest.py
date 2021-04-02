# Link: https://leetcode.com/problems/delete-nodes-and-return-forest/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def traverseTree(self, root, nodesToDelete, remainingNodes):
        
        # If root is empty, exit function
        if root == None:
            return None
        
        # Visit children
        # NOTE: Value is assigned directly to root's children because the tree is being modified.
        root.left = self.traverseTree(root.left, nodesToDelete, remainingNodes)
        root.right = self.traverseTree(root.right, nodesToDelete, remainingNodes)
        
        # Check if root exist inside of nodesToDelete
        if root.val in nodesToDelete:
            
            if root.left != None:
                remainingNodes.append(root.left)
            
            if root.right != None:
                remainingNodes.append(root.right)
                
            return None
        
        return root
    
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        
        # If root is empty, exit function
        if root == None:
            return [root]
        
        # If to_delete is empty, exit function
        if to_delete == None or len(to_delete) == 0:
            return [root]
        
        # Turn to_delete list into a set
        nodesToDelete = set(to_delete)
        
        # Traverse tree
        remainingNodes = list()
        self.traverseTree(root, nodesToDelete, remainingNodes)
            
        # If root doesn't have to be deleted, then add it to remainingNodes[]
        if root.val not in nodesToDelete:
            remainingNodes.append(root)
        
        return remainingNodes
        
