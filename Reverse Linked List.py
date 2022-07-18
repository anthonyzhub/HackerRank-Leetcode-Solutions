# https://leetcode.com/problems/reverse-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    def makeNewList(self, head: Optional[ListNode]):
        
        """
        Time Complexity: O(n) where n = length of linked list. I iterate through the linked list once adding all nodes to a list. I go through the list
                        and add each node's value to a new node.
        
        Space Complexity: O(n) where n = length of new linked list. The new linked list is the original linked list in reverse order.
        """
        
        # Create a list
        history = list()
        
        # Iterate linked list
        while head != None:
            history.append(head)
            head = head.next
        
        # Create a new linked list
        newLL = ListNode(-1)
        newHead = newLL
        
        # Iterate stack
        for node in reversed(history):
            newLL.next = ListNode(node.val)
            newLL = newLL.next
            
        return newHead.next
    
    def swapInPlace(self, head: Optional[ListNode]):
        
        """
        Time Complexity: O(n) where n = length of linked list. The original linked list is traversed through in order to add all nodes to list. After
                        the nodes are added, the next pointers are reset in the for-loop. In the for-loop each node is linked to the next element inside
                        the list.
                        
        Space Complexity: O(n) where n = length of list. A list is used to temporarily store all nodes until the linked list is reversed
        """
        
        # Create a history
        history = list()
        
        # Iterate linked list
        while head != None:
            history.insert(0, head)
            head = head.next
        
        # Iterate list
        for idx in range(len(history)):
            
            # If current node isn't at the end of the list, link this node to next node
            if idx + 1 < len(history):
                history[idx].next = history[idx + 1]
                
            # Set last remaining node's next pointer to none to avoid cycle
            else:
                history[idx].next = None
        
        # Return head of new linked list
        return history[0]
    
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        # If head is empty or by itself, return it
        if head is None or head.next is None:
            return head
        
        return self.swapInPlace(head)
