// https://leetcode.com/problems/check-completeness-of-a-binary-tree/

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
    public boolean isCompleteTree(TreeNode root) {
        
        // If root is empty or by itself, return true
        if (root == null || (root.left == root.right)) {return true;}
        
        // Create a queue for breadth-first search
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // Create a boolean variable representing whether or not a null node was discovered
        boolean discoveredNull = false;
        
        // Search tree
        while (!queue.isEmpty()) {
            
            // Pop 1st node
            TreeNode popped = queue.pop();
            
            // Check if there's a left child
            if (popped.left != null) {
                
                // If boolean variable is true, then return false
                if (discoveredNull) {return false;}
                
                // Add left child to queue
                queue.add(popped.left);
                
            // If left child is null, set boolean variable to true
            } else {
                discoveredNull = true;
            }
                
            // Check if there's a right child
            if (popped.right != null) {
                
                // If boolean variable is true, then return false
                if (discoveredNull) {return false;}
                
                // Add right child to queue
                queue.add(popped.right);
            }
            
            // If right child is null, set boolean variable to true
            else {
                discoveredNull = true;
            }
        }
        
        // If function is still continuing, return true because this is a complete binary tree
        return true;
    }
}
