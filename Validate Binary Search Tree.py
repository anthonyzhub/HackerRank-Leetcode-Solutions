# https://leetcode.com/problems/validate-binary-search-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def inOrder(self, root, nodesVisited):

        # If node is none, exit function
        if root is None:
            return
        
        # Continue to visit leftside children, itself, then rightside children
        self.inOrder(root.left, nodesVisited)
        nodesVisited.append(root.val)
        self.inOrder(root.right, nodesVisited)
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        # If root is None, exit function
        if root is None:
            return True
        
        # Create a list to hold node values
        # NOTE: BST can't have duplicate values
        nodesVisited = list()
        
        # Traverse tree inorder
        self.inOrder(root, nodesVisited)
        
        """ EXPLANATION
        1. BST cannot have duplicate values and must follow the following rule: left.val < root.val < right.val.
            The closest traversal to this rule is inorder because all left children are visited first, then root, then right children.
            If nodesVisited captured nodes in unsorted order, then tree is not valid!
            
        2. set() is a good data structure to hold unique elements, so it will remove duplicate values inside of nodesVisited.
            Once that is done, compare the size of the original list with the set. If both aren't equal in length, then there were
            duplicates inside the binary search tree, which is not allowed!
        """
        isPositionValid = nodesVisited == sorted(nodesVisited)
        doDuplicatesExist = len(nodesVisited) == len(set(nodesVisited))
        
        return isPositionValid and doDuplicatesExist
