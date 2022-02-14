// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

// https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    
    public int traverse(TreeNode root, int depth)
    {
        // If root is empty, exit function
        if (root == null) {return depth;}
        
        // Increment depth
        depth++;
        
        // Vist children
        int leftChildDepth = traverse(root.left, depth);
        int rightChildDepth = traverse(root.right, depth);
        
        // Get maximum value between left and right subtree
        return Math.max(leftChildDepth, rightChildDepth);
    }
    
    public int maxDepth(TreeNode root) {
        
        // If root is empty, exit function
        if (root == null) {return 0;}
        
        return traverse(root, 0);
    }
}
