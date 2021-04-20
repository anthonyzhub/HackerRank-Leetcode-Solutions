// Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/

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
    
    public TreeNode makeTree(int[] nums, int leftPtr, int rightPtr)
    {
        // If pointers overlap, exit function
        if (leftPtr > rightPtr)
        {
            return null;
        }
        
        // Get index of middle position
        int midPoint = (leftPtr + rightPtr) / 2;
        
        // Create tree
        TreeNode newNode = new TreeNode(nums[midPoint]);
        newNode.left = makeTree(nums, leftPtr, midPoint - 1);
        newNode.right = makeTree(nums, midPoint + 1, rightPtr);
        
        // Return root
        return newNode;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        // Turn array to tree
        return makeTree(nums, 0, nums.length - 1);
    }
}
