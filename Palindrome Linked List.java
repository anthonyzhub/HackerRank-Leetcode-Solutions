// https://leetcode.com/problems/palindrome-linked-list/

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
    Time Complexity: O(n) where n = length of linked list
    Space Complexity: O(n) where n = length of stack
 */
class Solution {

    private void populateStack(ListNode head, Stack<Integer> stack) {
        ListNode curNode = head;
        while (curNode != null) {
            stack.push(Integer.valueOf(curNode.val));
            curNode = curNode.next;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Create a stack
        Stack<Integer> stack = new Stack<>();
        populateStack(head, stack);

        // Iterate list
        ListNode curNode = head;
        while (curNode != null) {
            if (stack.peek() == Integer.valueOf(curNode.val)) {
                stack.pop();
                curNode = curNode.next;
                continue;
            }

            return false;
        }

        return true;
    }
}
