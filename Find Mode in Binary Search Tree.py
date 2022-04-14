# https://leetcode.com/problems/find-mode-in-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import sys

class Solution:
    
    def traverseTree(self, root, dict_nodes):
        
        # OBJECTIVE: Traverse tree and add node's value to dict as key and number of occurrences to key's value
        
        # If root is empty, exit function
        if root is None:
            return
        
        # Add node to dict
        if root.val in dict_nodes.keys():
            dict_nodes[root.val] += 1
        else:
            dict_nodes[root.val] = 1
            
        # Traverse left and right subtree
        self.traverseTree(root.left, dict_nodes)
        self.traverseTree(root.right, dict_nodes)
    
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        
        # If root is empty, exit function
        if root is None:
            return
        
        # If root doesn't have children, return its value
        if root.left is None and root.right is None:
            return [root.val]
        
        # Create a dictionary
        dict_nodes = dict()
        
        # Traverse tree
        self.traverseTree(root, dict_nodes)
        
        # Get maximum value in dictionary
        max_value = max(dict_nodes.values())
        
        # Iterate dictionary and look for key(s) that has the max_value
        popular_nodes = list()
        for nodeVal, occurrence in dict_nodes.items():
            
            # If current value equals to max_value, then save node's value to list
            if occurrence == max_value:
                popular_nodes.append(nodeVal)
                
        # Return popular_nodes list
        return popular_nodes
            
