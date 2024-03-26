// https://leetcode.com/problems/maximum-depth-of-n-ary-tree

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public int calculateMaxDepth(Node root, int depth) {

        /*
         * Time Complexity: O(n * m) where n = the number of nodes inside the tree and m = the number
         *  of children per node. For each method call, the root's children are iterated in the for-loop.
         * 
         * Space Complexity: O(log n) in a balanced tree to O(n) in an unbalanced tree where n = the
         *  number of nodes inside the tree.
         */

        // If root is null, exit function and return calculated depth
        if (root == null) {
            return depth;
        }

        // Update depth counter and pass it to maxDepth for future use
        depth += 1;
        int maxDepth = depth;

        // Iterate root's children
        for (Node child: root.children) {

            // Calculate max depth of current child and, if necessary, update maxDepth
            maxDepth = Math.max(maxDepth, calculateMaxDepth(child, depth));
        }

        return maxDepth;
    }

    public int maxDepth(Node root) {
        // Added 0 here because I'll calculate the tree's depth in another function
        return calculateMaxDepth(root, 0);
    }
}