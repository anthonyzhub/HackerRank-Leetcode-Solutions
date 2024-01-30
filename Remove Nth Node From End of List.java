// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        /*
         * Time Complexity: O(n) where n = length of linked list. We have to iterate the entire
         *  list to find the nth to last node.
         * 
         * Space Complexity: O(1) because no dynamic data structure was created. Only 3 nodes were
         *  created and they take constant space to make.
         */

        // If head is empty or by itself, return null
        if (head == null || head.next == null) {
            return null;
        }
        
        // Create a dummy node to help return value
        ListNode dummy = new ListNode();
        dummy.next = head;

        // Create a left and right node pointer
        ListNode leftNode = dummy;
        ListNode rightNode = head;

        // Move rightNode n steps
        for (int i = 0; i < n; i++) {
            rightNode = rightNode.next;
        }

        // Iterate linked list until rightNode reaches end of list
        while (rightNode != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        // Cut target node from linked list
        leftNode.next = leftNode.next.next;

        return dummy.next;
    }
}