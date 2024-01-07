// https://leetcode.com/problems/linked-list-cycle/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        /*
         * Time Complexity: O(n) where n = length of linked list
         * Space Complexity: O(1) because no dynamic data structures were created. Only 2 extra nodes.
         */

        // If linked list is empty or head isn't linked to anything, return false
        if (head == null || head.next == null) {return false;}

        // Create 2 nodes - tortoise and the haire
        ListNode tortoise = head;
        ListNode haire = head;

        // If there are no more nodes for the haire to move to, exit loop
        while (haire.next != null && haire.next.next != null) {

            tortoise = tortoise.next;
            haire = haire.next.next;

            if (tortoise == haire) {
                return true;
            }
        }

        return false;
}
