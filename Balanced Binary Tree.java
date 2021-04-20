// Link: https://leetcode.com/problems/balanced-binary-tree/submissions/

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
    
    public int nodeHeight(TreeNode root)
    {
        // If root is null, return depth
        if (root == null)
        {
            return -1;
        }
        
        // Traverse left and right side of the root
        int leftSide = nodeHeight(root.left);
        int rightSide = nodeHeight(root.right);
        
        // Return max height between children
        return Math.max(leftSide, rightSide) + 1; // <= Added '1' because root is not null, so depth is increased
    }
    
    public boolean isBalanced(TreeNode root) {
        
        // If root is null, return true
        if (root == null)
        {
            return true;
        }
        
        // If root doesn't have any kids, return true
        if (root.left == null && root.right == null)
        {
            return true;
        }
        
        // Get height of root
        int rootHeight = Math.abs(nodeHeight(root.left) - nodeHeight(root.right));
        
        // Check if root's children's subtree is balanced
        boolean leftSubtree = isBalanced(root.left);
        boolean rightSubtree = isBalanced(root.right);
        
        // If root's height <= 1 and both children's subtrees are balanced, return true
        if (rootHeight <= 1 && leftSubtree == true && rightSubtree == true)
        {
            return true;
        }
        
        return false;
    }
}
