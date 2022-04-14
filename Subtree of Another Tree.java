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
    
    public boolean compareTrees(TreeNode root, TreeNode subRoot) {
        
        // If both roots are null, return true
        if (root == null && subRoot == null) {return true;}
        
        // If either roots are null, return false
        if (root == null || subRoot == null) {return false;}
        
        // If both roots don't share the same value, return false
        if (root.val != subRoot.val) {return false;}
        
        // Check left and right subtrees on both roots
        boolean leftSubTree = compareTrees(root.left, subRoot.left);
        boolean rightSubTree = compareTrees(root.right, subRoot.right);
        
        // If entire subRoot and its children were found together inside of root, return true.
        // If not, return false
        return leftSubTree && rightSubTree;
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        // If both roots are null, return true
        if (root == null && subRoot == null) {return true;}
        
        // If either roots are null, return false
        if (root == null || subRoot == null) {return false;}
        
        // Check if subtree is part of root
        if (compareTrees(root, subRoot)) {return true;}
        
        // If subtree hasn't been found yet, move down in root
        boolean leftSubTree = isSubtree(root.left, subRoot);
        boolean rightSubTree = isSubtree(root.right, subRoot);
        
        // If subRoot was found on root's left or right side, return true.
        // If not, return false
        return leftSubTree || rightSubTree;
    }
}
