# https://leetcode.com/problems/unique-binary-search-trees-ii/submissions/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def recursiveCall(self, startPtr, endPtr):
        
        # If pointers pass one another, exit function
        if startPtr > endPtr:
            return [None]
        
        # If pointers overlap, then node is a leaf
        if startPtr == endPtr:
            return [TreeNode(startPtr)]
        
        # Create subtrees
        treesList = list()
        for idx in range(startPtr, endPtr + 1):
            
            # Create child nodes
            leftChild = self.recursiveCall(startPtr, idx - 1)
            rightChild = self.recursiveCall(idx + 1, endPtr)
            
            # Add children to parent
            # NOTE: product() comes from itertools and iterates all possible combinations (Cartesian product)
            #       https://riptutorial.com/python/example/5615/itertools-product
            for children in product(leftChild, rightChild):
                
                # Create a parent node
                parentNode = TreeNode(idx, children[0], children[1])
                
                # Add parent node to list
                treesList.append(parentNode)
                
        return treesList
    
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        
        # If n is 1, then only one node needs to be created
        if n == 1:
            return [TreeNode(1)]
        
        return self.recursiveCall(1, n)
