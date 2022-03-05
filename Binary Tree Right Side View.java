// https://leetcode.com/problems/binary-tree-right-side-view/

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
    
    public void traverseTree(TreeNode root, ArrayList<Integer> log, int curDepth) {
      
        // OBJECTIVE: Traverse tree starting from the right side of each node then visit the left side. During each visit, add node's value to list.
        
        // If root is empty, exit function
        if (root == null) {return;}
        
        // Go to most-recent level then add node to list
        if (log.size() == curDepth) {
            log.add(root.val);
        }
        
        // Visit right child
        traverseTree(root.right, log, curDepth + 1);
        traverseTree(root.left, log, curDepth + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        
        // Create an array list
        ArrayList<Integer> log = new ArrayList();
        
        // Traverse tree
        traverseTree(root, log, 0);
        return log;
    }
}
