// https://leetcode.com/problems/count-complete-tree-nodes/

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
    public int countNodes(TreeNode root) {
        
        // If root is null, exit function
        if (root == null) {return 0;}
        
        // If root is by itself, exit function
        if (root.left == null && root.right == null) {return 1;}
        
        // Create 2 new arrays
        ArrayList<TreeNode> children = new ArrayList<TreeNode>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        
        // Add root to queue
        queue.add(root);
        
        while (queue.size() > 0) {
            
            // Pop first node from array
            TreeNode node = queue.remove(0);
                
            // If node isn't null, add it to children array
            if (node != null) {
                children.add(node);
            }

            // If node has any children, add it to queue
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            // Remove node from queue
            queue.remove(node);
        }
        return children.size();
    }
}
