# https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def getHeight(self, root, height):
        
        # OBJECTIVE: Get maximum height of tree
        
        # If root is empty, return height
        if root is None:
            return height
        
        # Increment height
        height += 1
        
        # Get maximum height from children
        height = max(self.getHeight(root.left, height), self.getHeight(root.right, height))
        return height
    
    def traverseTree(self, root, level, levelSum):
        
        # OBJECTIVE: Traverse tree, collect sum of each level, and save it to levelSum
        
        # If root is empty, exit function
        if root is None:
            return 0
        
        # If root isn't empty and doesn't have any children, return its value
        if root.left is None and root.right is None:
            return root.val
        
        # Get sum of root's children
        total = self.traverseTree(root.left, level + 1, levelSum) + self.traverseTree(root.right, level + 1, levelSum)
        
        # Add total to levelSum
        levelSum[level + 1] += total
        
        # NOTE: Root's value needs to be returned or else program will throw an error.
        # In the recursive call, a value is expected to return. Plus, you can't add an integer with a null variable
        return root.val
    
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        
        """
        OBJECTIVE: Return smallest level inside the tree that its sum is greater than all the other levels
        
        Time Complexity: O(2n) where n = # of nodes inside the tree and l = # of levels inside the tree.
                        getHeight() calculate the tree's maximum height by visiting every node. traverseTree()
                        visits every node and then calculates the level's sum.
        
        Space Complexity: O(2n) where n = # of nodes inside the tree. levelSum[] holds n elements and traverseTree() creates a new memory stack per node
        """
        
        # If root is empty, exit function
        if root is None:
            return
        
        # If root is by itself, return its value
        if root.left is None and root.right is None:
            return root.val
        
        # Create a list to hold sum of each level
        levelSum = [0] * self.getHeight(root, 0)
        
        # Add head element to list
        levelSum[0] = root.val
        
        # Calculate sum of each level
        self.traverseTree(root, 0, levelSum)
        
        # Return index of maximum element
        return levelSum.index(max(levelSum)) + 1
