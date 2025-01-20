// https://leetcode.com/problems/add-two-numbers/
// https://youtu.be/wgFPrzTjm7s?si=-hlGspLKG4CD4iJB

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
 Time Complexity: O(n) where n = size of longest linked list
 Space Complexity: O(n) where n = size of result linked list
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return Objects.nonNull(l1) ? l1 : l2;
        }

        // Create a new linked list
        ListNode dummyNode = new ListNode();
        ListNode curNode = dummyNode;

        // Create a placeholder for first digit of a 2 digit number.
        int carry = 0;

        // Iterate list until both linked lists have been iterated and no digit is being carried
        while (l1 != null || l2 != null || carry != 0) {

            // If node isn't null, get its value
            int l1Digit = Objects.nonNull(l1) ? l1.val : 0;
            int l2Digit = Objects.nonNull(l2) ? l2.val : 0;

            // Add numbers
            int newNumber = l1Digit + l2Digit + carry;
            
            // E.g., newNumber = 13, carry = 1, (updated) newNumber = 3
            // IMPORTANT: Remember that we received the numbers in reverse order and we need to return it in reverse order
            carry = (int) newNumber / 10;
            newNumber %= 10;
            curNode.next = new ListNode(newNumber);

            // Move to next node
            curNode = curNode.next;
            l1 = Objects.nonNull(l1) ? l1.next : null;
            l2 = Objects.nonNull(l2) ? l2.next : null;
        }

        return dummyNode.next;
    }
}
