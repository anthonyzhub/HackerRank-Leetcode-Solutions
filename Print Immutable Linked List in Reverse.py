# Link: https://leetcode.com/problems/print-immutable-linked-list-in-reverse/

# """
# This is the ImmutableListNode's API interface.
# You should not implement it, or speculate about its implementation.
# """
# class ImmutableListNode:
#     def printValue(self) -> None: # print the value of this node.
#     def getNext(self) -> 'ImmutableListNode': # return the next node.

class Solution:
    def printLinkedListInReverse(self, head: 'ImmutableListNode') -> None:
        
        # Create a list
        ans = list()
        
        
        # Iterate link list and push node to list
        while head != None:
            
            ans.insert(0, head)
            head = head.getNext()
        
        # Iterate list and call printValue() from node
        for i in ans:
            i.printValue()
        
