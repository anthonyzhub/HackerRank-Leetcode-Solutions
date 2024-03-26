// https://leetcode.com/problems/invert-binary-tree/

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
    public TreeNode invertTree(TreeNode root) {

        /*
         * Time Complexity: O(1) because I'm not using any loops in this solution
         * 
         * Space Complexity: O(n) where n = the number of nodes the input tree has. For every node,
         *  I'm making a recursive call to flip its children.
         */

        // If root is null or it doesn't have any children, return itself
        // FYI: By verifying it has children, I'm saving time by not adding another method call in the 
        // memory stack 
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        // Create a temporary hold for one of its children
        TreeNode holder = root.left;

        // Flip children
        root.left = root.right;
        root.right = holder;

        // Flip all descendants
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}