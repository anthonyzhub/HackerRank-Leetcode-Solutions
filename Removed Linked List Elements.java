// https://leetcode.com/problems/remove-linked-list-elements/

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
    public ListNode removeElements(ListNode head, int val) {
        
        /*
        * OBJECTIVE: Remove nodes containing val from Linked List
        *
        * Time Complexity: O(n) where n = # of nodes inside the linked list. This function traverses the linked list in linear time
        *
        * Space Complexity: O(1) because no dynamic data structures were created. An extra node was created, but it will always occupy constant space
        */
        
        // If head is null, exit function
        if (head == null) {return head;}
        
        // Create a new node
        ListNode curNode = head;
        
        // Iterate linked list
        while (curNode != null && curNode.next != null) {
            
            // If next node's value equals to val, skip next node
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
            }
            
            // If not, move to next node
            else {
                curNode = curNode.next;
            }
        }
        
        // If head isn't null, its value equals to target value, and isn't by itself, update head node
        if (head != null && head.val == val && head.next != null) {
            head = head.next;
        }
        
        // If head isn't null, its value equals to target value, and it's by itself, return null because there's no more nodes in the linked list
        if (head != null && head.val == val && head.next == null) {
            head = null;
        }
        
        return head;
    }
}
