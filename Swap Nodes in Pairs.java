// Link: https://leetcode.com/problems/swap-nodes-in-pairs/

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
    public ListNode swapPairs(ListNode head) {
        
        // If head is null or by itself, exit function
        if (head == null || head.next == null)
        {
            return head;
        }
        
        // Create a dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // Copy head and dummy nodes
        ListNode preNode = dummy;
        ListNode curNode = head;
        
        // Iterate link list
        while (curNode != null && curNode.next != null)
        {
            
            // Connect preNode to 2nd node
            preNode.next = curNode.next;
            
            // Move curNode to node after the next one
            curNode.next = curNode.next.next;
            
            // Connect preNode.next to 1st node
            preNode.next.next = curNode;
            
            // Update nodes
            preNode = preNode.next.next;
            curNode = curNode.next;
        }
        
        // Return what's after dummy node
        return dummy.next;
    }
}
