// https://leetcode.com/problems/reverse-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    
    public ListNode makeNewList(ListNode head) {
        
        /*
        Time Complexity: O(n) where n = length of linked list. I iterate through the linked list once adding all nodes to a list. I go through the list
                        and add each node's value to a new node.
        
        Space Complexity: O(n) where n = length of new linked list. The new linked list is the original linked list in reverse order.
        */
        
        // Create a stack
        Stack<ListNode> stack = new Stack<ListNode>();
        
        // Iterate linked list
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        
        // Create a new linked list
        ListNode newLL = new ListNode();
        ListNode curNode = newLL;
        
        // Iterate stack
        while (!stack.empty()) {
            
            // Pop stack and save popped element as a temporary node
            ListNode tmp = new ListNode(stack.pop().val);
            
            // Add temporary node to linked list
            curNode.next = tmp;
            curNode = curNode.next;
        }
        
        return newLL.next;
    }
    
    public ListNode swapInPlace(ListNode head) {
        
        /*
        Time Complexity: O(n) where n = length of linked list. The original linked list is traversed through in order to add all nodes to list. After
                        the nodes are added, the next pointers are reset in the for-loop. In the for-loop each node is linked to the next element inside
                        the list.
                        
        Space Complexity: O(n) where n = length of list. A list is used to temporarily store all nodes until the linked list is reversed
        */
        
        // Create a stack
        Stack<ListNode> stack = new Stack<ListNode>();
        
        // Iterate linked list
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        
        // Create a new Linked List
        ListNode newLL = new ListNode();
        ListNode curNode = newLL;
        
        // Iterate stack
        while (!stack.empty()) {
            curNode.next = stack.pop();
            curNode = curNode.next;
        }
        
        curNode.next = null;
        return newLL.next;
    }
    
    public ListNode reverseList(ListNode head) {
        
        // If head is null or by itself, return it
        if (head == null || head.next == null) {return head;}
        
        // return makeNewList(head);
        return swapInPlace(head);
    }
}
