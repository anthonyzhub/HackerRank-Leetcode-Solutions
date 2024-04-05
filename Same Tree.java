// https://leetcode.com/problems/same-tree/

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // If both are null, then trees are identical
        if (p == null && q == null) {
            return true;
        }

        // If either root is null, then trees aren't identical
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        // Check if roots share the same value
        if (p.val == q.val) {

            // Check if both subtrees are identical
            boolean leftSubtree = isSameTree(p.left, q.left);
            boolean rightSubtree = isSameTree(p.right, q.right);

            return leftSubtree && rightSubtree;
        }

        return false;
    }
}