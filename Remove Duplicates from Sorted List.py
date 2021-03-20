# Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        
        # Exit if list is either empty or only has one node
        if head == None or head.next == None:
            return head
        
        # Create 3 nodes
        headNode = head # <= A head node will have to be returned
        oldNode = head
        currNode = head.next
        
        while currNode != None:
            
            # If pair are duplicates, continue to move currNode
            if currNode.val == oldNode.val:
                
                # If currNode is already at the end of the list, then end it at oldNode and exit
                if currNode.next == None:
                    oldNode.next = None
                    break
                else:
                    currNode = currNode.next
            
            else:
                
                # If a duplicate wasn't found, move both nodes
                oldNode.next = currNode
                oldNode = currNode
                currNode = currNode.next
            
        return headNode
