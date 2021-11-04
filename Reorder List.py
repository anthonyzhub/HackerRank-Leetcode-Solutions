# https://leetcode.com/problems/reorder-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        
        # If head is by itself, exit function
        if head.next is None:
            return
        
        # Create a list to hold nodes
        nodesList = list()
        
        # Add all nodes to list
        currNode = head
        while currNode != None:
            
            # Add node to list and move to next node
            nodesList.append(currNode)
            currNode = currNode.next
        
        # Iterate list
        for idx, currNode in enumerate(nodesList):
            
            # Get last element
            lastNode = nodesList.pop(-1)
            
            # Connect current node to last node
            currNode.next = lastNode
            
            # If lastNode is truly the last node in the list, point it to none
            if idx + 1 >= len(nodesList):
                lastNode.next = None
                
            # If there's another node in the list, update lastNode's pointer
            else:
                lastNode.next = nodesList[idx + 1]
