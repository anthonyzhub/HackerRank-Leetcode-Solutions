// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*
Time Complexity: O(n) where n = length of original linked list. The original linked list is being iterated 2 times.

Space Complexity: O(k) where k = # of keys inside Hash Map.

Thought Process:
- Create a map where key = oldNode, value = newNode
- Iterate original linked list
- while iterating,
    - Create a deepy copy of existing node
    - Insert old node and new node to map
- Create a dummy node and reference to head of new linked list
- Iterate old linked list again
- Upon every iteration, fetch new node and update its next and random pointer
- Return head of new linked list
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();

        Node curNode = head;
        while (curNode != null) {
            Node newNode = new Node(curNode.val);
            nodeMap.put(curNode, newNode);
            curNode = curNode.next;
        }

        Node dummyNode = new Node(0);
        dummyNode.next = nodeMap.get(head);

        curNode = head;
        while (curNode != null) {
            Node newNode = nodeMap.get(curNode);
            
            if (curNode.next != null) {
                newNode.next = nodeMap.get(curNode.next);
            }
            
            if (curNode.random != null) {
                newNode.random = nodeMap.get(curNode.random);
            }

            curNode = curNode.next;
        }

        return dummyNode.next;
    }
}
