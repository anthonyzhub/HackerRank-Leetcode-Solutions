# https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        # If root is empty, exit function
        if root is None:
            return []
        
        # If root doesn't have children, exit function
        if root.left is None and root.right is None:
            return [[root.val]]
        
        # Create a list to hold all nodes
        finalList = list()
        
        # Create a list to hold nodes that need to be visited
        queue = [root]
        
        # Iterate queue while it's not empty
        while queue:
            
            # Check nodes in queue
            currLevel = list()
            for idx in range(len(queue)):
                
                # Get 1st node from queue
                currNode = queue.pop(0)
                
                # Check if we didn't go past a leaf node
                if currNode is not None:
                    
                    # Add node to list
                    currLevel.append(currNode.val)
                    
                    # Add children to queue
                    queue.append(currNode.left)
                    queue.append(currNode.right)
            
            # If there are nodes on this level, add level to list
            if len(currLevel) != 0:
                finalList.append(currLevel)
        
        return finalList
