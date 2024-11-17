// https://leetcode.com/problems/remove-nodes-from-linked-list/
// https://youtu.be/y783sRTezDg?si=FE63wECVnZnLdrfP

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
 Space Complexity: O(n) where n = length of the stack
 */
class Solution {

    private Stack<Integer> reverseStack(Stack<Integer> oldStack) {
        Stack<Integer> newStack = new Stack<>();
        while (!oldStack.isEmpty()) {
            newStack.push(oldStack.pop());
        }

        return newStack;
    }

    public ListNode removeNodes(ListNode head) {
        
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Iterate linked list
        ListNode curNode = head;
        while (curNode != null) {
            while (!stack.isEmpty() && curNode.val > stack.peek()) {
                stack.pop();
            }

            stack.push(curNode.val);
            curNode = curNode.next;
        }

        stack = reverseStack(stack);

        // Go through stack and create a new linked list
        // NOTE: Insert dummyNode as the temproary head of the new linked list
        ListNode dummyNode = new ListNode();
        curNode = dummyNode;
        while (!stack.isEmpty()) {
            curNode.next = new ListNode(stack.pop());
            curNode = curNode.next;
        }

        // Return true linked list's head
        return dummyNode.next;
    }
}
