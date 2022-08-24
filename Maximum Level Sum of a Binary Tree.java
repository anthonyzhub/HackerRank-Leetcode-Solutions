// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

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
    
    public int getHeight(TreeNode root, int height) {
        
        // OBJECTIVE: Return tree's maximum height
        
        // If root is null, exit function
        if (root == null) {return height;}
        
        // Increment height
        height++;
        
        // Visit root's children
        return Math.max(getHeight(root.left, height), getHeight(root.right, height));
    }
    
    public int traverseTree(TreeNode root, int level, int[] levelSum) {
        
        // OBJECTIVE: Traverse tree and collect total level sum
        
        // If root is null, return 0
        if (root == null) {return 0;}
        
        // If root is by itself, return its value
        if (root.left == null && root.right == null) {return root.val;}
        
        // Get sum of children's level
        int total = traverseTree(root.left, level + 1, levelSum) + traverseTree(root.right, level + 1, levelSum);
        
        // Add total to array
        levelSum[level + 1] += total;
        
        // NOTE: Root's value needs to be returned or else program will throw an error.
        // In the recursive call, a value is expected to return. Plus, you can't add an integer with a null variable
        return root.val;
    }
    
    public int maxLevelSum(TreeNode root) {
        
        /*
        OBJECTIVE: Return smallest level inside the tree that its sum is greater than all the other levels
        
        Time Complexity: O(n) where n = # of nodes inside the tree. getHeight() calculate the tree's maximum                            height by visiting every node. traverseTree() visits every node and then calculates                            the level's sum. The last for-loop iterates levelSum in order to find index of maximum value.
        
        Space Complexity: O(n) where n = # of nodes inside the tree. levelSum[] holds n elements and                                   traverseTree() creates a new memory stack per node.
        */
        
        // If root is null, return 0
        if (root == null) {return 0;}
        
        // If root is by itself, return its value
        if (root.left == null && root.right == null) {return 1;}
        
        // Create an array
        int height = getHeight(root, 0);
        int[] levelSum = new int[height];
        
        // Add head element to array
        levelSum[0] = root.val;
        
        // Traverse tree
        traverseTree(root, 0, levelSum);
        
        // Iterate array and capture index of maximum element
        int maxNum = levelSum[0];
        int maxIdx = 0;
        
        for (int i=0; i<levelSum.length; i++) {
            if (levelSum[i] > maxNum) {
                maxNum = levelSum[i];
                maxIdx = i;
            }
        }
        
        // Return index of maximum element
        // NOTE: Level numbering started at 0, so add 1 to return value
        return maxIdx + 1;
    }
}
