# https://leetcode.com/problems/linked-list-random-node/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from random import randint

class Solution:

    def traverseList(self, head):
        
        # OBJECTIVE: Traverse link list and add each node to dictionary
        
        # Create a temporary node
        currNode = head
        
        # Iterate list
        counter = 0
        while currNode != None:
            
            # Update counter and add node to dictionary
            counter += 1
            self.dic[counter] = currNode
            
            # Move to next node
            currNode = currNode.next
    
    def __init__(self, head: Optional[ListNode]):
        

        # Create a dictionary
        self.dic = dict()
        
        # Traverse list
        self.traverseList(head)
        
    def getRandom(self) -> int:
        
        # OBJECTIVE: Return a random node's value
        
        # Generate a random number from 1 to N nodes
        randomNum = randint(1, len(self.dic.keys()))
        
        # Return random node's value
        randomNode = self.dic[randomNum]
        return randomNode.val

# Your Solution object will be instantiated and called as such:
# obj = Solution(head)
# param_1 = obj.getRandom()
