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
Map of memory addresses{
    original node: new node
}

Steps:

1. Create a new list based on next pointer
2. For every new node, store original node and clone to map where original node is key and clone is value.
    - In this step, map is storing the memory addresses of each node.
3. Iterate original list again and find node being pointed by random pointer in map
4. Connect new node to the random node's clone

===
Time Complexity: O(n) where n = size of linked list
Space Complexity: O(n) where n = size of linked list. The size affects the size of the map and cloned linked list.
*/

class Solution {

    private Node createCloneLinkedList(Node head, Map<Node, Node> nodeMap) {

        // Create new linked list
        Node origNode = head;
        Node cloneNode = new Node(0);
        Node dummyNode = new Node(0);
        dummyNode.next = cloneNode;

        // Iterate original linked list
        while (origNode != null) {
            
            // Override default value
            cloneNode.val = origNode.val;

            // Insert memory address of each node to map
            nodeMap.put(origNode, cloneNode);
            
            origNode = origNode.next;

            // IMPORTANT: Added this because if I didn't, cloned linked list would end with an extra node
            if (origNode != null) {
                cloneNode.next = new Node(0);
                cloneNode = cloneNode.next;
            }
        }

        return dummyNode.next;
    }

    private void populateRandomPointers(Node origHead, Node cloneHead, Map<Node, Node> nodeMap) {

        Node origNode = origHead;
        Node cloneNode = cloneHead;

        // IMPORTANT: After a successful cloning, both linked lists are the same size
        while (origNode != null) {

            // If random pointer is null, move to next node in both linked lists
            if (origNode.random == null) {
                origNode = origNode.next;
                cloneNode = cloneNode.next;
                continue;
            }

            // Get clone of random pointer and update curNode in cloned linked list
            cloneNode.random = nodeMap.get(origNode.random);

            origNode = origNode.next;
            cloneNode = cloneNode.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>();

        Node cloneHead = createCloneLinkedList(head, nodeMap);
        populateRandomPointers(head, cloneHead, nodeMap);

        return cloneHead;
    }
}
