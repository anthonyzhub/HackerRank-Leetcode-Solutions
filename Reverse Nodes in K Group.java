// https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    
    public int getSize(ListNode head)
    {
        int length = 0;
        ListNode curNode = head;
        while (curNode != null)
        {
            length++;
            curNode = curNode.next;
        }
        
        return length;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        // If head is null or by itself, exit function
        if (head == null || head.next == null) {return head;}
        
        // Get linked list size
        int size = getSize(head);
        
        // If K is greater than size, exit function
        if (k > size) {return head;}
        
        // Create 3 nodes as pointers
        ListNode curNode = head;
        ListNode preNode = new ListNode();
        ListNode nextNode = new ListNode();
        
        // Create a counter
        int counter = 0;
        
        // Iterate linked list
        while (curNode != null && counter < k)
        {
            // Update nodes
            nextNode = curNode.next;
            curNode.next = preNode;
            
            // Swap nodes
            preNode = curNode;
            curNode = nextNode;
            counter++;
        }
        
        // After swapping 1st K elements, swap the next pair
        head.next = reverseKGroup(nextNode, k);
        return preNode;
    }
}
