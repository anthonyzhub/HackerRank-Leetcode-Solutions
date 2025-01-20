// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// https://youtu.be/XVuQxVej6y8?si=wLbsrSn2F0GLpjNd

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

/*
Time Complexity: O(n) where n = size of linked list. It's important to remember that the question is asking for the nth last element.

Space Complexity: O(1) because no additional dynamic memory was created
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        // Move rightNode n nodes ahead
        ListNode rightNode = head;
        while (n > 0 && rightNode != null) {
            rightNode = rightNode.next;
            n--;
        }

        // Create a dummy node connected to head. This will be used for the return value.
        ListNode dummy = new ListNode();
        dummy.next = head;

        // Iterate linked list. Keep in mind, leftNode is n spaces away from rightNode
        ListNode leftNode = dummy;
        while (rightNode != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        // IMPORTANT: At this point, rightNode is null so I have to use leftNode.next.next
        leftNode.next = leftNode.next.next;
        return dummy.next;
    }
}
