# https://leetcode.com/problems/delete-node-in-a-linked-list/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        
        """
        OBJECTIVE: Remove node from linked list
        
        Time Complexity: O(n) where n = # of remaining nodes inside the linked list from the given node's
                        position. The linked list is iterated through from node's position.
                        
        Space Complexity: O(1) because no additional space was needed
        """
        
        # Iterate linked list
        while node.next.next != None:
            
            # Swap values with next node
            oldVal = node.val
            node.val = node.next.val
            node.next.val = oldVal
            
            # Move to next node
            node = node.next
        
        # Move value from next node to this node
        # NOTE: At this point, node is behind the last node of the linked list
        node.val = node.next.val
        node.next = None
