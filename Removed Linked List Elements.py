# https://leetcode.com/problems/remove-linked-list-elements/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        
        """
        * OBJECTIVE: Remove nodes containing val from Linked List
        *
        * Time Complexity: O(n) where n = # of nodes inside the linked list. This function traverses the linked list in linear time
        *
        * Space Complexity: O(1) because no dynamic data structures were created. An extra node was created, but it will always occupy constant space
        """
        
        # If head is None, exit function
        if head is None:
            return head
        
        # If head has val and is by itself, return it
        if head.val == val and head.next is None:
            head = None
            return head
        
        # Create a new node
        curNode = head
        
        # Iterate linked list
        while curNode != None and curNode.next != None:
            
            # If next node contains val, connect curNode to the node after the next one
            if curNode.next.val == val:
                curNode.next = curNode.next.next
                
            # If not, move to next node
            else:
                curNode = curNode.next
                
        # If head isn't none, head.next isn't none, and head's value equals to val, update head node
        if head != None and head.next != None and head.val == val:
            head = head.next
            
        # If head isn't none, head.next is none, and head's value equals to val, set head node to None
        if head != None and head.next == None and head.val == val:
            head = None
            
        return head
