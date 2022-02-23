// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    
    public int getSize(ListNode head) {
        // OBJECTIVE: Calculate linked list size
        
        ListNode curNode = head;
        int length = 0;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }
        
        return length;
    }
    
    public ListNode moveNode(ListNode head, int startIdx) {
        // OBJECTIVE: Move node to starting position
        
        // Create a new node
        ListNode curNode = head;
        
        // Cycle list until "i" reaches "startIdx"
        for (int i=0; i<startIdx; i++) {
            curNode = curNode.next;
        }
        
        return curNode;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        // If either head is null, return null
        if (headA == null || headB == null) {return null;}
        
        // Get length of both lists
        int lengthA = getSize(headA);
        int lengthB = getSize(headB);
        
        // Create 2 nodes and set start points
        ListNode curNodeA = headA;
        ListNode curNodeB = headB;
        
        // Move either node to equal starting position
        int diff = 0;
        if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            curNodeA = moveNode(curNodeA, diff);
        }
        else if (lengthB > lengthA) {
            diff = lengthB - lengthA;
            curNodeB = moveNode(curNodeB, diff);
        }
        
        // Start cycling lists
        while (curNodeA != null || curNodeB != null) {
            
            // Return intersecting node if both pointers are identical
            if (curNodeA == curNodeB) {
                return curNodeA;
            }
            
            // Move nodes
            curNodeA = curNodeA.next;
            curNodeB = curNodeB.next;
        }
        
        // If condition above wasn't met, return null
        return null;
    }
}
