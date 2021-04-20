// Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/

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
    
    public int minDepth(TreeNode root) {
        
        // If root is null, return 0
        if (root == null) {return 0;}
        
        // If root doesn't have any kids, return 1
        if (root.left == null && root.right == null) {return 1;}
        
        // Traverse left and right subtrees
        int minDepthHolder = Integer.MAX_VALUE;
        if (root.left != null)
        {
            minDepthHolder = Math.min(minDepth(root.left), minDepthHolder);
        }
        
        if (root.right != null)
        {
            minDepthHolder = Math.min(minDepth(root.right), minDepthHolder);
        }
        
        return minDepthHolder + 1;
    }
}
