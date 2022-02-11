// Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

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
    
    public void traverse(TreeNode root, List<Integer> path)
    {
        // Exit function if root is empty
        if (root == null)
            return;
        
        // Add root's value to list
        path.add(root.val);
        
        // Traverse subtree
        traverse(root.left, path);
        traverse(root.right, path);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        // Pre-order: Root, left, then right
        
        // Create a list
        List<Integer> path = new ArrayList();
        traverse(root, path);
        
        // Return list
        return path;
    }
}
