# Link: https://leetcode.com/problems/merge-two-sorted-lists/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def printList(self, l1):
        
        output = ""
        while l1 != None:
            output += "{} ".format(l1.val)
            l1 = l1.next
            
        print(output)
    
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        
        # Base cases: Exit if one or both list are empty
        if l1 == None and l2 == None:
            return l1
        
        if l1 == None and l2 != None:
            return l2
        
        if l1 != None and l2 == None:
            return l1
        
        # Create new nodes and a copy head node
        currNode = ListNode()
        headNode = currNode
        
        # Compare both lists as long as they're not empty
        while l1 != None and l2 != None:
            
            if l1.val <= l2.val:
                
                # Link currNode to current l1 node
                currNode.next = l1
                
                # Update l1 node
                l1 = l1.next
                
            else:
                
                # Link currNode to current l2 node
                currNode.next = l2
                
                # Update l2 node
                l2 = l2.next
                
            # Move to next node
            currNode = currNode.next
                
        # Add remaining nodes from either list
        if l1 != None:
            currNode.next = l1
        elif l2 != None:
            currNode.next = l2
            
        return headNode.next
