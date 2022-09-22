# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def __init__(self):
        self.res = None
    
    def traverseTree(self, root, p, q):
        
        # OBJECTIVE: Return a boolean variable indicating if p and q nodes were found
        
        # If root is empty, exit function
        if root is None:
            return False
        
        # Set true if root equals to p or q
        curNode = (root == p) or (root == q)
        
        # Set true if left subtree has nodes p or q
        leftSubtree = self.traverseTree(root.left, p, q)
        
        # Set true if right subtree has nodes p or q
        rightSubtree = self.traverseTree(root.right, p, q)
        
        # If nodes p and q were found, se tres node as common ancestor
        """
        * curNode & leftSubtree => If p or q is root node and the other node is descendant of current root, set res node as current root
        * curNode & rightSubtree => If p or q is root node and the other node is descendant of current root, set res node as current root
        * leftSubtree & rightSubtree => If p and q were found in root's left and right subtrees, set res as current root
        """
        if (curNode and leftSubtree) or (curNode and rightSubtree) or (leftSubtree and rightSubtree):
            self.res = root
        
        # Return boolean variable indicating whether or not p and q were found
        return curNode or leftSubtree or rightSubtree
    
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        # OBJECTIVE: Return the lowest common ancestor of nodes p and q
        
        # If root is empty, exit function
        if root is None:
            return root
        
        # If root equals to p or q, return root
        if (root == p) or (root == q):
            return root
        
        # Traverse tree and return res node
        self.traverseTree(root, p, q)
        return self.res
        
