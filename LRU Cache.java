/* 
https://leetcode.com/problems/lru-cache/
https://youtu.be/7ABFKPK2hD4?si=54mIuEyLdwju4-6l

Thought Process
- Create a node class that has value, prevNode, and rightNode pointers
- Create a linked list class that manages all the nodes
    - Linked list should be a doubly linked list to keep track of head and tail nodes
    - When adding a new element, create a new node, insert it at the beginning of the list, and return the new node
    - For every node that is interacted with, move that node to the beginning of the list
    - If linked list's size exceeds original capacity, drop last node
- In LRUCache, initialize hash map and linked list
- Hash map will keep track of number and node (key = number, value = node)
- For every insert, check if capacity hasn't been met yet. If linked list size exceeds, remove lru node then add new node. If key exist, simply update node.
- For every get, check if key exist. If it does, return its value. If not, return -1 
*/

class Node {
    int key;
    int value;
    Node next;
    Node prev;
}

class DoublyLinkedList {
    Node head;
    Node tail;
    
    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public Node add(int key, int value) {
        // Create a new node
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;

        // Insert newNode between head and 2nd node in linked list
        newNode.next = head.next;
        head.next.prev = newNode;

        head.next = newNode;
        newNode.prev = head;

        // Return newNode to add it to map
        return newNode;
    }

    public void moveToFront(Node curNode) {

        // Disconnect current neighbors from curNode
        Node leftNode = curNode.prev;
        Node rightNode = curNode.next;

        leftNode.next = rightNode;
        rightNode.prev = leftNode;

        // Insert curNode between head and 2nd node in list
        curNode.next = head.next;
        head.next.prev = curNode;

        head.next = curNode;
        curNode.prev = head;
    }

    public Node dropLastNode() {
        // NOTE: Validation is always being done in LRUCache class, so we don't need to worry about tail.prev.prev throwing a Null Exception
        Node nodeToDelete = tail.prev;
        Node secondToLastNode = tail.prev.prev;

        secondToLastNode.next = tail;
        tail.prev = secondToLastNode;

        return nodeToDelete;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> nodeMap;
    DoublyLinkedList linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        linkedList = new DoublyLinkedList();
    }
    
    public int get(int key) {
        /*
        - If key doesn't exist, return -1
        - If key does exist, return the associated node's value
        */

        if (nodeMap.containsKey(key)) {
            Node existingNode = nodeMap.get(key);
            linkedList.moveToFront(existingNode);
            return existingNode.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        /*
        - If key doesn't exist, check if linked list exceeds capacity
        - If linked list exceeds capacity, immediately drop last node. If not, add new node to map and linked list
        - If key does exist, update its value and move node to front of linked list
        */

        if (!nodeMap.containsKey(key)) {
            if (capacity == 0) {
                Node oldNode = linkedList.dropLastNode();
                nodeMap.remove(oldNode.key); // IMPORTANT: We still need the least recently used key to remove it from map
                capacity++;
            }

            Node newNode = linkedList.add(key, value);
            nodeMap.put(key, newNode);
            capacity--;
        } else {
            Node existingNode = nodeMap.get(key);
            existingNode.value = value;

            nodeMap.put(key, existingNode);
            linkedList.moveToFront(existingNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
