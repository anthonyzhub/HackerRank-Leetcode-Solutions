// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

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
    
    public int getSize(ListNode head)
    {
        // Create a new node and a counter
        ListNode tmpNode = head;
        int length = 0;
        
        // Iterate list
        while (tmpNode != null)
        {
            tmpNode = tmpNode.next;
            length++;
        }
        
        return length;
    }
    
    public ListNode swapNodes(ListNode head, int k)
    {
    
        // Get linked list size
        int size = getSize(head);
        
        // If K is greater than linked list's size, exit function
        if (k > size) {return head;}
        
        // Copy head node and create an array
        ListNode curNode = head;
        ListNode[] array = new ListNode[size];
        
        // Save each node to array
        for (int i=0; i<size; i++)
        {
            array[i] = curNode;
            curNode = curNode.next;
        }
        
        // Swap values
        int tmpHolder = array[k-1].val;
        array[k-1].val = array[size - k].val;
        array[size - k].val = tmpHolder;
        
        return head;
    }
}
