# https://leetcode.com/problems/linked-list-cycle-ii/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        
        # If head is empty, return nothing
        if head is None:
            return head
        
        # If head is by itself, return itself
        if head.next is None:
            return None
        
        # Create a list
        nodesVisited = list()
        
        # Iterate link list
        currNode = head
        while currNode != None:
            
            # Check if node has been visited
            if currNode in nodesVisited:
                return currNode
            
            # Add node to log
            nodesVisited.append(currNode)
            
            # Update node
            currNode = currNode.next
            
        return None
