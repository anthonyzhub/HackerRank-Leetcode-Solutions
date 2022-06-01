# https://leetcode.com/problems/count-complete-tree-nodes/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def countNodes(self, root: Optional[TreeNode]) -> int:
      
        """
          OBJECTIVE: Count the number of nodes there are in the binary tree with a time complexity less than O(n).
          NOTE: I answered the question by using BFS. I used BFS to collect all nodes on the same level.
                The time complexity is O(n) where n = number of nodes inside the tree.
        """
        
        # If root is node is empty, exit function
        if root is None:
            return 0
        
        # If root is by itself, return 1
        if root.left is None and root.right is None:
            return 1
        
        # Create a children and queue list
        children = []
        queue = [root]
        
        while queue:
            
            # Iterate queue list
            for node in queue:
                
                # If node isn't empty, add it to list
                if node != None:
                    children.append(node)
                    
                # If node has any children, add it to queue
                if node.right:
                    queue.append(node.right)
                    
                if node.left:
                    queue.append(node.left)
                
                # Remove node from queue
                queue.remove(node)
                
        return len(children)
