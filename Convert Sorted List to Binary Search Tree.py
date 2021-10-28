# https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    def createTree(self, nodesList):
        
        # If list is empty, exit function
        if len(nodesList) == 0:
            return None
        
        if len(nodesList) == 1:
            return TreeNode(nodesList[0])
        
        # Pop middle element as root
        midIdx = len(nodesList) // 2
        root = TreeNode(nodesList[midIdx])
        
        # Make a recursive call
        root.left = self.createTree(nodesList[:midIdx])
        root.right = self.createTree(nodesList[midIdx + 1:])
        
        # Return head of tree
        return root
    
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        
        # If link list is empty, return none
        if head is None:
            return None
        
        # If link list only has 1 element, return element
        if head.next is None:
            return TreeNode(head.val)
        
        # Convert link list to regular list
        nodesList = list()
        currNode = head
        while currNode != None:
            nodesList.append(currNode.val)
            currNode = currNode.next
        
        # Convert list to tree
        return self.createTree(nodesList)
