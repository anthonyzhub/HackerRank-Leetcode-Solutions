// https://leetcode.com/problems/lru-cache/
// https://youtu.be/7ABFKPK2hD4?si=54mIuEyLdwju4-6l

class CustomNode {
    int key;
    int val;
    CustomNode next;
    CustomNode prev;

    public CustomNode(){}

    public CustomNode(int key, int value) {
        this.key = key;
        this.val = value;
    }

    public CustomNode(CustomNode oldNode) {
        this.key = oldNode.key;
        this.val = oldNode.val;
    }
}

class LRUCache {

    int curCapacity;
    int maxCapacity;
    CustomNode headNode;
    CustomNode tailNode;
    Map<Integer, CustomNode> nodeMap;

    public LRUCache(int capacity) {
        this.curCapacity = 0;
        this.maxCapacity = capacity;
        this.nodeMap = new HashMap<>();
        this.headNode = new CustomNode();
        this.tailNode = new CustomNode();

        headNode.next = tailNode;
        tailNode.prev = headNode;
    }

    private void insert(CustomNode newNode) {
        /*
        Time Complexity: O(1) because I'm not iterating through the linked list
        Space Complexity: O(1) because I'm only creating 1 node
        */
        CustomNode preNode = tailNode.prev;

        preNode.next = newNode;

        newNode.prev = preNode;
        newNode.next = tailNode;
        
        tailNode.prev = newNode;
    }

    private void remove(CustomNode targetNode) {
        /*
        Time Complexity: O(1) because I'm not iterating through the linked list
        Space Complexity: O(1)? I'm not creating a new object and I don't know if 0 is a possible answer. Maybe the call is O(1)?
        */
        CustomNode preNode = targetNode.prev;
        CustomNode nextNode = targetNode.next;

        preNode.next = nextNode;
        nextNode.prev = preNode;
    }

    public int get(int key) {

        // IMPORTANT: If a node exist, we're simply deleting the existing one and inserting its replacement on the far left where the most recently used node is used.
        if (nodeMap.containsKey(key)) {
            remove(nodeMap.get(key));
        }
        else {
            return -1;
        }

        CustomNode newNode = new CustomNode();
        newNode.key = key;
        newNode.val = nodeMap.get(key).val;

        nodeMap.put(key, newNode);
        insert(newNode);

        return newNode.val;
    }
    
    public void put(int key, int value) {

        // If key exist, replace existing node and exit function
        if (nodeMap.containsKey(key)) {

            // Remove node from map and linked list
            remove(nodeMap.get(key));
            nodeMap.remove(key);

            // Create a new node of the same key and different value
            CustomNode newNode = new CustomNode();
            newNode.key = key;
            newNode.val = value;

            // Add new node to linked list and map
            insert(newNode);
            nodeMap.put(key, newNode);
            return;
        }

        // If cache is at max capacity, remove least recently used (lru) node
        // IMPORTANT: Remember that the linked list is holding a list of nodes. From left to right, it's from least used to recently used
        if (curCapacity == maxCapacity) {
            CustomNode lruNode = headNode.next;
            remove(lruNode);
            nodeMap.remove(lruNode.key);
            curCapacity--;
        }

        // Add new node to linked list
        CustomNode newNode = new CustomNode(key, value);
        nodeMap.put(key, newNode);
        insert(newNode);
        curCapacity++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
