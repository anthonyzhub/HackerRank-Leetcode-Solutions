# https://leetcode.com/problems/copy-list-with-random-pointer

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        # If head is empty, return None
        if head is None:
            return None
        
        # Create a new head node
        headClone = Node(head.val)
        
        # Create a dictionary and counter
        nodesDict = {head: headClone}
        
        # Iterate original link list
        oldClone = headClone
        currNode = head.next
        while currNode != None:
            
            # Create a new clone node
            newClone = Node(currNode.val)
            
            # Connect previous clone node to new clone
            oldClone.next = newClone
            oldClone = oldClone.next
            
            # Add newClone to dictionary
            nodesDict[currNode] = newClone
            
            # Update currNode
            currNode = currNode.next
            
        # Iterate original link list (again) for random pointer
        oldClone = headClone
        currNode = head
        while currNode != None:
            
            # Update "random" pointer in clone link list
            if currNode.random in nodesDict:
                oldClone.random = nodesDict[currNode.random]
                
            # Update nodes
            oldClone = oldClone.next
            currNode = currNode.next
            
        return headClone
