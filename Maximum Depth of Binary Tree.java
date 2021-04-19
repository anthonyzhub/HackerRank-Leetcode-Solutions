// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/

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
        // If node is empty, exit function
        if (root == null)
        {
            return depth;
        }
        
        // Increment counter
        depth += 1;
        
        // Traverse left and right side
        int leftSide = 0;
        int rightSide = 0;
        
        if (root.left != null)
        {
            leftSide = traverse(root.left, depth);
        }
        
        if (root.right != null)
        {
            rightSide = traverse(root.right, depth);
        }
        
        // Get maximum depth between the two
        return Math.max(leftSide, Math.max(rightSide, depth));
    }
    
    public int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }
}
