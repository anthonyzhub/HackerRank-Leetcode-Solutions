# https://leetcode.com/problems/check-completeness-of-a-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        
        """
        OBJECTIVE: Return true if given binary tree is complete. If not, return false
        
        NOTE: A complete binary tree only has NULL nodes at the bottom, far-right side of the tree. I.e, if a tree has N nodes, then N - 1 nodes can't be null!
        
        Time Complexity: O(n) where n = # of nodes because the tree is being traversed once through breadth-first search
        
        Space Complexity: O(n) where n = # of nodes because all the nodes are being added to a queue during a breadth-first search
        """
        
        # If root is empty or by itself, return true
        if root is None or (root.left == root.right == None):
            return True
        
        # Use bfs() to traverse tree
        queue = deque([root])
        discoveredNull = False # <= Create a variable to determine if a None node was discovered
        
        while queue:
            
            # Pop first element from queue
            popped = queue.popleft()
            
            # Check if there's a left child
            if popped.left:
                
                # If a null node was previously discovered, return false
                if discoveredNull:
                    return False
                
                # Add left child to queue
                queue.append(popped.left)
                
            # If left child is null, set boolean variable to true
            else:
                discoveredNull = True
            
            # Check if there's a right child
            if popped.right:
                
                # If a null node was previously discovered, return false
                if discoveredNull:
                    return False
                
                # Add right child to queue
                queue.append(popped.right)
                
            # If right child is null, set boolean variable to true
            else:
                discoveredNull = True
        
        # If function is still continuing, then tree is complete
        return True
