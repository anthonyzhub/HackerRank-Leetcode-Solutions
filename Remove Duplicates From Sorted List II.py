# Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        
        # If head is a NoneType, exit function
        if head is None:
            return head
        
        # If head is the only node, exit function
        if head.next is None:
            return head
        
        # Create a dummy node as temporary head
        dummyNode = ListNode(0, head)
        
        # Create node iterators
        predecessorNode = dummyNode
        
        # Iterate link list
        while head:
            
            # Check if list starts with duplicates
            if head.next != None and head.val == head.next.val:
                
                # Continue to iterate link list
                # NOTE: head is moving to last duplicate node
                while head.next != None and head.val == head.next.val:
                    head = head.next
                    
                # Move predecessorNode to skip all duplicates
                predecessorNode.next = head.next
                
            else:
                
                # Update predecessor if duplicates weren't found
                predecessorNode = predecessorNode.next
                
            # Update head node
            head = head.next
            
        # Return node after dummyNode
        return dummyNode.next
