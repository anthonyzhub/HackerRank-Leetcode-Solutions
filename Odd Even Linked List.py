# https://leetcode.com/problems/odd-even-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        """
        OBJECTIVE: Group nodes with odd indices to the front, then group nodes with even indices to the back.
        
        Time Complexity: O(n) where n = length of linked list. This function iterates the linked list once
        
        Space Complexity: O(1) because no additional space was created. All the postive-index nodes were disconnected from their original linked list.
                            They were never duplicated and added to another linked list
        """
        
        # If linked list is empty, exit function
        if head is None:
            return None
        
        # Create a new linked list for nodes with even indices
        even = head.next
        evenHead = even
        
        # Copy head node as head of odd linked list
        odd = head
        
        # Iterate linked list
        while even is not None and even.next is not None:
            
            # Move odd node pointer to the next odd-index node
            odd.next = even.next
            odd = odd.next
            
            # Move even node pointer to the next even-index node
            even.next = odd.next
            even = even.next
            
        # Connect the end of odd linked list to even linked list
        odd.next = evenHead
        
        # Return original head
        # NOTE: head was never touched
        return head
