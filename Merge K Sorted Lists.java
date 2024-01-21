// https://leetcode.com/problems/merge-k-sorted-lists/

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

    public ListNode mergeKLists(ListNode[] lists) {

        /*
         * Time Complexity: O(n) where n = total number of nodes in every linked list. 
         *  Every node will be added to queue and popped in the while-loop.
         * 
         * Space Complexity: O(n) = where n = total number of nodes in every linked list.
         *  Each node will be added to queue.
         */
        
        // If lists is empty, return null
        if (lists.length == 0) {
            return null;
        }

        // If there's only 1 element inside list, return it
        if (lists.length == 1) {
            return lists[0];
        }

        // Create a max heap priority queue
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(Comparator.comparingInt(o -> o.val));

        // Create new nodes
        ListNode newHead = new ListNode();
        ListNode curNode = newHead;

        // Only add non-empty nodes to priority queue
        for (ListNode node: lists) {
             if (node != null) {
                 queue.add(node);
             }
        }

        // Iterate queue
        while (!queue.isEmpty()) {

            // Pop queue
            curNode.next = queue.poll();
            curNode = curNode.next;

            // If popped node has a neighbor, add neighbor to queue
            if (curNode.next != null) {
                queue.add(curNode.next);
            }
        }

        return newHead.next;
    }
}