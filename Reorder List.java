/*
https://leetcode.com/problems/reorder-list/
https://youtu.be/S5bfdUTrKLM?si=x9l9iP-IGXSOG5sb

Time Complexity: O(n) where n = size of linked list. 

Space Complexity: O(1)
*/

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
    public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) {
            return;
        }

        // Find mid point of linked list
        // NOTE: This is a faster way of getting to the mid point of the linked list
        //  The other option would be to iterate 2x. Also, if linked list is odd, first half will have an extra element
        ListNode tortoise = head;
        ListNode hare = head.next;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        // Reverse 2nd half of linked list
        // NOTE: While iterating 2nd half, we need current node to point to previous node
        ListNode curNode = tortoise.next;
        tortoise.next = null;

        ListNode prevNode = null;
        while (curNode != null) {
            // Copy link to next node
            ListNode holder = curNode.next;

            // Connect next node to prev node
            curNode.next = prevNode; // NOTE: On 1st iteration, this would define the tail node
            prevNode = curNode; // Update to new prevNode
            curNode = holder; // Move to next node
        }

        // Merge both halves
        ListNode curNodeA = head;
        ListNode curNodeB = prevNode;

        while (curNodeB != null) {
            // Temporary hold the next node on each list
            // NOTE: We will be cutting the connection
            ListNode holderA = curNodeA.next;
            ListNode holderB = curNodeB.next;

            // Re-order the list
            curNodeA.next = curNodeB;
            curNodeB.next = holderA;

            // Update pointers
            curNodeA = holderA;
            curNodeB = holderB;
        }
    }
}
