// https://leetcode.com/problems/binary-tree-postorder-traversal/

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
    
    public void postorder(TreeNode root, List<Integer> nodes) {
        
        // If root is null, exit function
        if (root == null) {return;}
        
        // Visit children first
        postorder(root.left, nodes);
        postorder(root.right, nodes);
        
        // Add root node to list
        nodes.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        // OBJECTIVE: Traverse tree in postorder (left, right, root)
        
        // Create a list
        List<Integer> nodes = new ArrayList<Integer>();
        
        // If root is null, return an empty list
        if (root == null) {return nodes;}
        
        // Traverse tree
        postorder(root, nodes);
        return nodes;
    }
}
