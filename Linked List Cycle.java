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
        
        // If head is empty or not linked to anything, return false
        if (head == null || head.next == null) {return false;}
        
        // Create a list and a new node
        ArrayList<ListNode> log = new ArrayList();
        ListNode curNode = head;
        
        // Cycle linked list
        while (curNode != null) {
            
            // If node already exist inside array list, return true
            if (log.contains(curNode) == true) {
                return true;
            }
            
            // Add node to array list
            log.add(curNode);
            curNode = curNode.next;
        }
        
        // If function is still continuing, then cycle is non-existent
        return false;
    }
}
