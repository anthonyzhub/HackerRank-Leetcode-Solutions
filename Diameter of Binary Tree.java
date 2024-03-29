// https://leetcode.com/problems/diameter-of-binary-tree/

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
    private int maxDiameter;

    private int dfs(TreeNode root) {

        // A tree with no children has a height of 0
        if (root == null) {
            return 0;
        }

        // Calculate maximum height of subtrees
        int maxLeftHeight = dfs(root.left);
        int maxRightHeight = dfs(root.right);

        // Update maxDiameter by merging height of both subtrees
        maxDiameter = Math.max(maxDiameter, maxLeftHeight + maxRightHeight);

        // (Because this is a dfs algorithm) Return maximum subtree height and add 1 for current root
        return Math.max(maxLeftHeight, maxRightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        /*
         * Time Complexity: O(n) where n = number of nodes inside tree
         * 
         * Space Complexity: O(n) where n = number of nodes inside tree. dfs() is called for every node.
         */
        maxDiameter = 0;
        dfs(root);
        return maxDiameter;
    }
}