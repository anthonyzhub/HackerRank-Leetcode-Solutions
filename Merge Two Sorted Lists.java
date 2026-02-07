/*
Link: https://leetcode.com/problems/merge-two-sorted-lists/

Time Complexity: O(n) where n = max(len(list1), len(list2)). 

Space Complexity: O(1). I did not create a new linked list for this problem

Thought process:
- If both lists are null, exit function
- If only 1 list is null, return the non-empty list
- Create a blank node that will link to the head. I'll use it to return the head at the end of the function
- Iterate list 1 and 2
- While iterating, connect to the next smallest node and check that next node in both lists isn't null
- If one list is shorter than the other, add the remaining elements from the long list after adding all elements from shorter list
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return list1;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // Create 2 new nodes for future use
        ListNode blankNode = new ListNode();
        ListNode curNode = new ListNode();
        
        // Create an iterate for both linked list
        ListNode itA = list1;
        ListNode itB = list2;

        // Immediately decide what will be the new head and move curNode
        if (itA.val <= itB.val) {
            curNode = itA;
            itA = itA.next;
        } else {
            curNode = itB;
            itB = itB.next;
        }

        // Link blankNode to curNode. blankNode will help return the new head
        blankNode.next = curNode;

        // Iterate list
        while (itA != null && itB != null) {

            // Connect smallest node to curNode and move curNode
            if (itA.val <= itB.val) {
                curNode.next = itA;
                curNode = curNode.next;

                itA = itA.next;
            } else {
                curNode.next = itB;
                curNode = curNode.next;

                itB = itB.next;
            }
        }

        // Add remaining elements
        if (itA != null) {
            curNode.next = itA;
        } else if (itB != null) {
            curNode.next = itB;
        }

        return blankNode.next;
    }
}
