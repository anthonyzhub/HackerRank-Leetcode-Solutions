// https://leetcode.com/problems/sum-of-left-leaves/

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
    
    public int traverseTree(TreeNode root, boolean isLeftChild, int leftLeavesSum) {
        
        // If root is null, exit function
        if (root == null) {return leftLeavesSum;}
        
        // If root is a left child and has no children, add its value to leftLeavesSum
        if (isLeftChild == true && root.left == null && root.right == null) {
            leftLeavesSum += root.val;
        }
        
        // Visit its children
        leftLeavesSum = traverseTree(root.left, true, leftLeavesSum);
        leftLeavesSum = traverseTree(root.right, false, leftLeavesSum);
        
        return leftLeavesSum;
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        
        // If root is by itself or null, return 0
        if (root == null || (root.left == null && root.right == null)) {return 0;}
        
        // Create a variable to hold sum of left leaf nodes
        int leftLeavesSum = 0;
        
        // Traverse tree
        leftLeavesSum = traverseTree(root, false, leftLeavesSum);
        return leftLeavesSum;
    }
}
