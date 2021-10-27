# https://leetcode.com/problems/recover-binary-search-tree/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def inorder(self, root, nodesVisited):
        
        # If root is None, exit function
        if root is None:
            return
        
        self.inorder(root.left, nodesVisited)
        nodesVisited.append(root)
        self.inorder(root.right, nodesVisited)
    
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        # Create a list to hold all nodes that were visited
        nodesVisited = list()
        
        # Traverse tree inorder
        self.inorder(root, nodesVisited)
        
        # Get number of nodes
        numOfNodes = len(nodesVisited)
        
        # Assume that the 1st node is in the incorrect order
        firstNode = nodesVisited[0]
        for idx in range(1, numOfNodes):
            
            # If current node is smaller than previous node, then BST is not sorted
            if nodesVisited[idx].val < nodesVisited[idx - 1].val:
                firstNode = nodesVisited[idx - 1]
                break
        
        # Assume that the last node is in the incorrect order
        lastNode = nodesVisited[-1]
        for idx in range(numOfNodes - 2, -1, -1): # <= NOTE: Start iteration from 2nd to last node, since I already have the last node
            
            # If current node is bigger than previous node, then BST is not sorted
            if nodesVisited[idx].val > nodesVisited[idx + 1].val:
                lastNode = nodesVisited[idx + 1]
                break
        
        # Swap both bad nodes
        tmpValue = firstNode.val
        firstNode.val = lastNode.val
        lastNode.val = tmpValue
