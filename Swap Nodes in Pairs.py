# LINK: https://leetcode.com/problems/swap-nodes-in-pairs/submissions/

"""
NOTE: Both solutions have the same runtime. Leetcode's solution uses 3 MB less in memory usage.
"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    def getSize(self, head):
        
        # Create counter
        total = 0
        
        # Create a new node
        currNode = head
        
        # Iterate link list
        while currNode != None:
            total += 1
            currNode = currNode.next
            
        return total
    
    def swapValues(self, nodeA, nodeB):
        
        oldVal = nodeA.val
        nodeA.val = nodeB.val
        nodeB.val = oldVal
    
    def mySwapPairs(self, head: ListNode) -> ListNode: # <= My solution
        
        # Base cases: Return head if it's a NoneType
        if head == None:
            return None
        
        # Get link list size
        listSize = self.getSize(head)
        
        # Return head, if it's by itself
        if listSize == 1:
            return head
        
        # Create 2 new nodes
        oldHead = head
        currNode = head
        
        # Iterate link list, if it's length is divisible by 2
        # NOTE: If list's length is odd and currNode is the last node, an error will occur on the while-condition
        if listSize % 2 == 0:
            while currNode != None:

                # Swap values with current node and next node
                self.swapValues(currNode, currNode.next)

                # Move to next node
                currNode = currNode.next.next
        else:
            
            while currNode.next != None:
            
                # Swap values with current node and next node
                self.swapValues(currNode, currNode.next)

                # Move to next node
                currNode = currNode.next.next
            
        return oldHead
            
    def leetCodeSwapPairs(self, head: ListNode) -> ListNode: # <= Leetcode's solution

        # If head is NoneType, return none
        if head == None:
            return None

        # If head is by itself, return itself
        if head.next == None:
            return head

        # Create a new node before the head
        fakeHead = ListNode(-1)
        fakeHead.next = head

        # Create a previous node holder
        prevNode = fakeHead

        while head and head.next:

            # Copy nodes
            nodeA = head
            nodeB = head.next

            # Swap nodes' positions
            prevNode.next = nodeB
            nodeA.next = nodeB.next
            nodeB.next = nodeA

            # Move to next node
            prevNode = nodeA
            head = nodeA.next

        # Return whichever node is after fakeHead
        return fakeHead.next
