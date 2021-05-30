# Link: https://leetcode.com/problems/partition-list/submissions/

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        
        # If head is a NoneType, exit function
        if head is None:
            return head
        
        # If head is the only node, exit function
        if head.next is None:
            return head
        
        # Create 2 pointers
        belowTargetNode = ListNode()
        aboveTargetNode = ListNode()
        
        # Save starting point of recently created nodes
        belowHead = belowTargetNode
        aboveHead = aboveTargetNode
        
        # Iterate link list
        while head:
            
            # Compare head's value to target
            if head.val < x:
                belowTargetNode.next = head
                belowTargetNode = belowTargetNode.next
                
            elif head.val >= x:
                aboveTargetNode.next = head
                aboveTargetNode = aboveTargetNode.next
                
            # Update head node
            head = head.next
            
        # Merge both link lists
        aboveTargetNode.next = None
        belowTargetNode.next = aboveHead.next
        
        return belowHead.next
