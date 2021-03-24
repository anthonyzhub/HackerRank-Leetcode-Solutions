# Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    def getSize(self, head):
        
        # Create a new node
        currNode = head
        
        # Keep track of size
        totalNodes = 0
        
        # Iterate list and keep track how many nodes there are
        while currNode != None:
            
            totalNodes += 1
            currNode = currNode.next
            
        # Return total
        return totalNodes
            
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        
        # Check if head is by itself
        if head.next == None:
            return None
        
        if head == None:
            return None
        
        # Get size of list
        listSize = self.getSize(head)
        
        # Copy head node and create a current node
        currHead = head
        currNode = head
        
        # Check if node to-be-deleted is head
        if listSize == n:
            currHead = currHead.next
            currNode.next = None
            
            return currHead
        
        # Iterate list
        for i in range(listSize):
            
            # Exit loop, if we're at node before the one to delete
            if i == listSize - n - 1:
                break
                
            currNode = currNode.next
            
        # Delete node
        currNode.next = currNode.next.next
        
        return currHead
