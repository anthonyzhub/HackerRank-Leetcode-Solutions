// https://leetcode.com/problems/clone-graph/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        /*
         * Time Complexity: O(n) where n = # of nodes inside the graph. For-loop had to explore every node in original graph.
         * Space Complexity: O(2n) where n = # of nodes inside the graph.
         *      A recursive call had to be made for each node inside the graph.
         *      The hash map also holds all the cloned nodes that were created.
         */
        
        if (node == null) {
            return node;
        }

        if (node.neighbors.size() == 0) {
            return new Node(node.val);
        }

        // Create a hashmap of all the cloned nodes that will be created
        HashMap<Integer, Node> nodesCreated = new HashMap<>();
        
        return dfs(nodesCreated, node);
    }

    public Node dfs(HashMap<Integer, Node> nodesCreated, Node curNode) {

        // If curNode was already created, return its clone
        if (nodesCreated.containsKey(curNode.val)) {
            return visited.get(curNode.val);
        }

        // Create a new clone node and add it to hashmap
        Node newNode = new Node(curNode.val);
        visited.put(newNode.val, newNode);

        // Iterate original node's neighbors, perform a dfs and add neighboring clone node to list
        for (Node neighbor: curNode.neighbors) {
            newNode.neighbors.add(dfs(visited, neighbor));
        }

        return newNode;
    }
}