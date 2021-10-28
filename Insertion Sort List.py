# https://leetcode.com/problems/insertion-sort-list/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        # If head is None, return None
        if head is None:
            return None
        
        # If link list only has 1 node, return node
        if head.next is None:
            return head
        
        # Use head as new node in sorted link list
        sortedHead = ListNode()
        sortedHead.next = ListNode(head.val)
        
        # Update head of unsorted list
        head = head.next
        
        # Iterate unsorted list
        while head != None:
            
            # Iterate sorted list
            currNode = sortedHead
            wasNodeAdded = False
            while currNode.next != None:
                
                # Find insertion point
                if currNode.next.val > head.val:
                    
                    # Create a new node
                    newNode = ListNode(head.val)
                    
                    # Insert newNode in-between current and following node
                    tmpNode = currNode.next
                    currNode.next = newNode
                    newNode.next = tmpNode
                    
                    # Update boolean variable
                    wasNodeAdded = True
                    
                    # Exit loop
                    break
                    
                # Update node
                currNode = currNode.next
                
            # If head wasn't added, then add it to the end of the sorted list
            if wasNodeAdded == False:
                newNode = ListNode(head.val)
                currNode.next = newNode
                
            # Update head node
            head = head.next
                
        return sortedHead.next
