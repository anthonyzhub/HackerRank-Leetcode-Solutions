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

 /*
 Time Complexity: O(n * log k) where n = length of the input list and k = length of the longest element inside the input list.
 Space Complexity: Same as time complexity (I blieve).
 */

class Solution {

    private ListNode mergeLinkedList(ListNode listA, ListNode listB) {
        
        // Create a new linked list
        ListNode dummyNode = new ListNode();
        ListNode curNode = dummyNode;

        // Redirect nodes from existing linked list to new linked list
        while (listA != null && listB != null) {

            // Remember to update listA's or listB's pointer
            if (listA.val < listB.val) {
                curNode.next = listA;
                listA = listA.next;
            }
            else {
                curNode.next = listB;
                listB = listB.next;
            }

            // Remember to update new linked list's pointer
            curNode = curNode.next;
        }

        // NOTE: It's possible that one list is shorter than the other. If so, simply connect to the remaining list
        if (listA != null) {
            curNode.next = listA;
        }
        else if (listB != null) {
            curNode.next = listB;
        }

        return dummyNode.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        // If input list is empty, return an empty list
        if (Objects.isNull(lists) || lists.length == 0) {
            return null;
        }

        // Iterate input list
        while (lists.length > 1) {

            // Create a temporary list that will hold merged linked lists
            List<ListNode> mergedLinkedLists = new ArrayList<>();

            // Iterate input list and get 2 elements at a time
            for (int i = 0; i < lists.length; i += 2) {

                // NOTE: linkedListB has a condition just in case (i + 1) causes out-of-bounds error
                ListNode linkedListA = lists[i];
                ListNode linkedListB = (i + 1) < lists.length ? lists[i + 1] : null;

                // Merge both linked lists and add them to temporary list
                ListNode newLinkedList = mergeLinkedList(linkedListA, linkedListB);
                mergedLinkedLists.add(newLinkedList);
            }

            // Update input list
            // NOTE: mergedLinkedLists will have a mix of merged linked lists and some original linked lists (reminder: we're handling 2 lists at a time)
            lists = mergedLinkedLists.toArray(new ListNode[0]);
        }

        return lists[0];
    }
}
