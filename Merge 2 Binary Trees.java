// https://leetcode.com/problems/merge-two-binary-trees/

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        // If either roots are empty, return the non-empty root
        // NOTE: If both are null, that is fine because no new nodes will be created
        if (root1 == null) {
            return root2;
        }
        else if (root2 == null) {
            return root1;
        }
        
        // Merge root2's value to root1
        root1.val += root2.val;
        
        // Merge root2's subtrees to root1
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        // Return root1 as merged tree
        return root1;
    }
}
