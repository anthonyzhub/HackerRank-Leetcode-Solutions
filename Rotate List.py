# Link: https://leetcode.com/problems/rotate-list/submissions/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    
    def getLength(self, head):
        
        currNode = head
        counter = 1
        
        while currNode.next != None:
            currNode = currNode.next
            counter += 1
            
        return counter
    
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        
        # If head is a NoneType, return head
        if head is None:
            return head
        
        # If linked list only has 1 node, return head
        if head.next is None:
            return head
        
        # If number of rotation is 0, return head
        if k == 0:
            return head
        
        # Get length of link list
        length = self.getLength(head)
        
        # If k is bigger than length, get remainder and pass its value to k
        if k >= length:
            k %= length
        
        # Rotate link list k-times
        for _ in xrange(k):
            
            # Go to last node
            currNode = head
            oldNode = head
            while currNode.next != None:
                oldNode = currNode
                currNode = currNode.next

            # Update pointer of the last 2 nodes
            tailNode = currNode
            oldNode.next = None

            # Update head node
            tailNode.next = head
            head = tailNode
            
        return head
        
