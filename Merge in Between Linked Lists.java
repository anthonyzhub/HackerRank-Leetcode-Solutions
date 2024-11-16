// https://leetcode.com/problems/merge-in-between-linked-lists/

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
 Time Complexity: O(m + n) where m = length of list1 and n = length of list2
 Space Complexity: O(1) because no additional dynamic memory is being used
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        // Iterate list1 until Ath index
        ListNode leftPtr = list1;
        for (int i=1; i < a; i++)
            leftPtr = leftPtr.next;
        
        // Iterate list1 from Ath index to Bth index
        ListNode middlePtr = leftPtr;
        for (int i=a; i <= b; i++)
            middlePtr = middlePtr.next;
        
        // Connect A-1 node to head of list2
        leftPtr.next = list2;

        // Iterate list2
        while (list2.next != null)
            list2 = list2.next;
        
        // Connect tail of list2 to B+1 node
        list2.next = middlePtr.next;

        return list1;
    }
}
