# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Link: https://leetcode.com/problems/add-two-numbers/submissions/

class Solution:
    
    def reverseArray(self, arr):
        
        newArr = list()
        for elem in arr[::-1]:
            newArr.append(elem)
            
        return newArr
    
    def iterateNode(self, headNode):
        
        newArr = list()
        while headNode != None:
            newArr.append(headNode.val)
            headNode = headNode.next
            
        return newArr
        
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        
        # Iterate nodes and insert value to array
        list1 = self.iterateNode(l1)
        list2 = self.iterateNode(l2)
        
        # Reverse both arrays
        list1 = self.reverseArray(list1)
        list2 = self.reverseArray(list2)
        
        # Turn int to str
        s1 = ''.join(str(i) for i in list1)
        s2 = ''.join(str(i) for i in list2)
        
        # Add as integer and turn sum into a list
        ans = list(str(int(s1) + int(s2)))
        
        # Create a ListNode from 1st element in ans[]
        headNode = ListNode(ans[-1])
        
        # Create a new ListNode per element inside ans[]
        oldNode = headNode
        for i in ans[-2::-1]:
            
            # Create a new ListNode with value i
            newNode = ListNode(i)
            
            # Link previous node with new one
            oldNode.next = newNode
            oldNode = newNode
            
        return headNode