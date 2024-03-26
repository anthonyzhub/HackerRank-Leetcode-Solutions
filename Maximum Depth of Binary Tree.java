// https://leetcode.com/problems/maximum-depth-of-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int calculateMaxDepth(TreeNode root, int depth) {

        /*
         * Time Complexity: O(1) because loops weren't used in this solution
         * 
         * Space Complexity: O(n) where n = the number of nodes inside the tree. For every node, I
         *  create another method call which gets added to the memory stack
         */

        // If root is null, exit function and return calculated depth
        if (root == null) {
            return depth;
        }

        // Update depth counter
        depth += 1;

        // Traverse the left and right subtree
        int leftDepth = calculateMaxDepth(root.left, depth);
        int rightDepth = calculateMaxDepth(root.right, depth);

        // Only return maximum depth between subtrees
        return Math.max(leftDepth, rightDepth);
    }

    public int maxDepth(TreeNode root) {
        // IMPORTANT: I added 0 here because I'll verify if root is null in the other function
        return calculateMaxDepth(root, 0);
    }
}