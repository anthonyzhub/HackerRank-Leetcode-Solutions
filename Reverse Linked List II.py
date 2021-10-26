# https://leetcode.com/problems/reverse-linked-list-ii/submissions/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        
        # If head is empty, exit function
        if head is None:
            return head
        
        # If head is by itself, return head
        if head.next is None:
            return head
        
        # If both variables are the same or right is 1, exit function
        # NOTE: Link list will remain the same
        if left == right or right == 1:
            return head
        
        # Create an iterator
        itNode = head
        
        # Iterate link list
        pos = 0
        queue = list()
        beginQueue = False
        while itNode != None:
            
            # Update position variable
            pos += 1
            
            # Find left and right values
            if pos == left:
                queue.append(itNode)
                beginQueue = True
                itNode = itNode.next
                continue
                
            elif pos == right:
                queue.append(itNode)
                beginQueue = False
                break
                
            # Only add nodes after finding left value
            if beginQueue:
                queue.append(itNode)
                
            itNode = itNode.next
                
        # Swap values
        while len(queue) > 1:
            
            # Get left and right node
            leftNode = queue.pop(0)
            rightNode = queue.pop(-1)
            
            # Create a temporary node and swap values
            tmpNode = leftNode.val
            leftNode.val = rightNode.val
            rightNode.val = tmpNode
            
        return head
