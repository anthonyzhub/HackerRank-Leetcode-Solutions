// https://leetcode.com/problems/odd-even-linked-list/

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
    public ListNode oddEvenList(ListNode head) {
        
        /*
        OBJECTIVE: Group nodes with odd indices to the front, then group nodes with even indices to the back.
        
        Time Complexity: O(n) where n = length of linked list. This function iterates the linked list once
        
        Space Complexity: O(1) because no additional space was created. All the postive-index nodes were disconnected from their original linked list.
                            They were never duplicated and added to another linked list
        */
        
        // If linked list is empty, exit function
        if (head == null) {return null;}
        
        // Create a new linked list for nodes at even indices
        ListNode even = head.next;
        ListNode evenHead = even; // <= This will server as head pointer for even linked list
        
        // Copy head pointer as head pointer of odd linked list
        ListNode odd = head;
        
        // Iterate given linked list
        while (even != null && even.next != null) {
            
            // Move odd node pointers to the next odd index
            odd.next = even.next;
            odd = odd.next;
            
            // Move even node pointers to the next even index
            even.next = odd.next;
            even = even.next;
        }
        
        // At the end of the regular linked list, connect even linked list
        odd.next = evenHead;
        
        // Return head of original linked list
        // NOTE: head was never touched
        return head;
    }
}
