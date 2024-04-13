// https://leetcode.com/problems/subtree-of-another-tree/

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

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        
        if (root == null || subRoot == null) {
            return root == null && subRoot == null; 
        }

        if (root.val == subRoot.val) {
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }

        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        /*
         * Time Complexity: O(h1 * h2) where h1 and h2 is the height from root's and subRoot's tree, respectively.
         *  isSubtree() goes through root's levels until it reaches a node where its value is the same
         *  as subRoot. Once that's found, it goes to isSameTree() which it iterates both trees.
         * 
         * Space Complexity: O(h1 * h2) for the same reason as above. For every method call, a new stack
         *  frame will be added the stack method call.
         * 
         */
        
        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}