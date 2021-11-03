# https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        # If root is empty, return an empty list
        if root is None:
            return []
        
        # If root is by itself, return itself
        if root.left is None and root.right is None:
            return [[root.val]]
        
        # Create lists
        queue = [root]
        finalList = list()
        leftToRight = True
        
        # Iterate queue
        while len(queue) != 0:
            
            
            # Iterate queue
            nodesOnLevel = list()
            for idx in range(len(queue)):
                    
                node = queue.pop(0)
                    
                # Add children to queue if they exist
                if node.left:
                    queue.append(node.left)
                
                if node.right:
                    queue.append(node.right)
                    
                # Save children to other list as well
                # NOTE: Must be saved right-left or left-right based on boolean variable
                if leftToRight:
                    nodesOnLevel.append(node.val)
                else:
                    nodesOnLevel.insert(0, node.val)
                    
            # Add nodes that were visited to finalList
            finalList.append(nodesOnLevel)
            leftToRight = not leftToRight
                    
        return finalList
