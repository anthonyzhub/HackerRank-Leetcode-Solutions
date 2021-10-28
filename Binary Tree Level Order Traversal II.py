# https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        # If root is empty, return an empty list
        if root is None:
            return []
        
        # If root doesn't have any kids, return a list of itself
        if root.left is None and root.right is None:
            return [[root.val]]
        
        # Create 2 lists
        finalList = list()
        queue = [root]
        
        # Iterate queue
        while queue:
            
            # Visit children
            nodesOnLevel = list()
            for idx in range(len(queue)):
                
                # Get current node
                currNode = queue.pop(0)
                
                # If "currNode" isn't a leaf node, continue
                if currNode is not None:
                    
                    # Add currNode to finalList
                    nodesOnLevel.append(currNode.val)
                    
                    # Add children to queue
                    queue.append(currNode.left)
                    queue.append(currNode.right)
                    
            # If any nodes existed on this level, add it to finalList
            if nodesOnLevel:
                finalList.append(nodesOnLevel)
                
        # Reverse final list
        return list(reversed(finalList))
