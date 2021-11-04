# https://leetcode.com/problems/sort-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    
    def mergeSort(self, leftHalf, rightHalf):
        
        # If either list is empty, return non-empty
        if leftHalf is None:
            return rightHalf
        
        if rightHalf is None:
            return leftHalf
        
        # Create a new node
        newList = ListNode()
        dummyNode = newList
        
        # Iterate left and right halves
        while leftHalf and rightHalf:
            
            # Compare values
            if leftHalf.val < rightHalf.val:
                
                # Connect newList to 1st node in left half
                newList.next = leftHalf
                
                # Update node
                leftHalf = leftHalf.next
    
            else:
            
                # Connect newList to 1st node in right half
                newList.next = rightHalf
                
                # Update node
                rightHalf = rightHalf.next
                
            # Update node
            newList = newList.next
            
        # If leftHalf is not None, but rightHalf is, add leftHalf to end of new list. Vice versa.
        if leftHalf:
            newList.next = leftHalf
            
        if rightHalf:
            newList.next = rightHalf
            
        # Return head of new list
        return dummyNode.next
    
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        # If head is empty, return itself
        if head is None:
            return head
        
        # If head is by itself, return itself
        if head.next is None:
            return head
        
        # Create 2 nodes
        fastNode = head.next
        slowNode = head
        
        # Iterate list
        # NOTE: This is used to find middle node
        while fastNode and fastNode.next:
            
            # Update both nodes
            # NOTE: A slow node moves to next node by 1, while a fast node moves by 2
            fastNode = fastNode.next.next
            slowNode = slowNode.next
            
        # Slice left-half of list
        startNode = slowNode.next
        slowNode.next = None # <= Need to cut left half of list from right half and slowNode happens to be in the middle
        
        # Sort left and right half of list
        leftHalf = self.sortList(head)
        rightHalf = self.sortList(startNode)
        
        # Merge both lists
        return self.mergeSort(leftHalf, rightHalf)
