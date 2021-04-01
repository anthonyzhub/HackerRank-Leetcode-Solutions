# Link: https://leetcode.com/problems/find-duplicate-subtrees/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def traverseTree(self, root, nodesVisited, repeatedSubTree):
        
        # If root is none, exit function
        if root == None:
            return "#"
        
        # Visit root's children
        leftChild = self.traverseTree(root.left, nodesVisited, repeatedSubTree)
        rightChild = self.traverseTree(root.right, nodesVisited, repeatedSubTree)
        
        # Get information about the node
        nodeInfo = "{} {} {}".format(root.val, leftChild, rightChild)
        
        # If information already exist in dictionary, increment value (number of occurrences)
        if nodeInfo in nodesVisited.keys():
            nodesVisited[nodeInfo] += 1
        else:
            nodesVisited[nodeInfo] = 1
            
        # If key's value is greater than 1, then there's a repeated subtree
        if nodesVisited[nodeInfo] == 2: # <= "> 1" was used because duplicates would be added then
            repeatedSubTree.append(root)
            
        return nodeInfo
    
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        
        # If root is none, exit function
        if root == None:
            return [root]
        
        # Create list to hold root of repeated subtree
        repeatedSubTree = list()
        
        # Create a dictionary to keep track of each node visited
        nodesVisited = dict()
        
        # Traverse subtree
        self.traverseTree(root, nodesVisited, repeatedSubTree)
        
        # Return list
        return repeatedSubTree
