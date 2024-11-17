// https://leetcode.com/problems/delete-node-in-a-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public void deleteNode(ListNode node) {
        
        /*
        OBJECTIVE: Remove node from linked list
        
        Time Complexity: O(n) where n = # of remaining nodes inside the linked list from the given node's
                        position. The linked list is iterated through from node's position.
                        
        Space Complexity: O(1) because no additional space was needed
        */

        // Create a pointer
        ListNode curNode = node;

        // Iterate list and make sure 2 nodes ahead of you isn't null
        while (curNode.next.next != null) {

            // Move neighboring node's value to current node
            int nextValue = curNode.next.val;
            curNode.val = nextValue;
            curNode = curNode.next;
        }

        // At the second to last node, copy next node's value and set next as null
        // NOTE: At this point, node is behind the last node of the linked list
        int nextValue = curNode.next.val;
        curNode.val = nextValue;
        curNode.next = null;
    }
}
