// https://leetcode.com/problems/merge-two-sorted-lists/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        /*
         * Time Complexity: O(n) where n = length of the longest linked list. If one list
         *  is longer than the other, then a 2nd while-loop will be triggered.
         * 
         * Space Complexity: O(1) because no additional data structure was created. I'm not creating
         *  an entirely new linked list. I just created a new data and corrected the links
         *  between the existing nodes in both linked lists.
         */

        // If either lists are null, return null or non-empty head
        if (list1 == null || list2 == null) {
            if (list1 == null & list2 == null) {return null;}
            else if (list1 == null) {return list2;}
            else if (list2 == null) {return list1;}
        }

        // If both are the only nodes in the linked list, return them in sorted order
        if (list1.next == null && list2.next == null) {
            if (list1.val <= list2.val) {
                list1.next = list2;
                return list1;
            }
            else {
                list2.next = list1;
                return list2;
            }
        }

        // Create new nodes
        ListNode newHead = new ListNode();
        ListNode curNode = newHead;
        newHead.next = curNode;

        // Iterate both linked lists until one of them ends first
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curNode.next = list1;
                curNode = curNode.next;

                list1 = list1.next;
            }
            else {
                curNode.next = list2;
                curNode = curNode.next;

                list2 = list2.next;
            }
        }

        // Add remaining nodes from list1 to new linked list
        while (list1 != null) {
            curNode.next = list1;
            curNode = curNode.next;

            list1 = list1.next;
        }

        // Add remaining nodes from list2 to new linked list
        while (list2 != null) {
            curNode.next = list2;
            curNode = curNode.next;

            list2 = list2.next;
        }
        
        return newHead.next;
    }
}