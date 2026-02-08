/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
https://youtu.be/gs2LMfuOR9k?si=dDIzQQeA9aHNR8Rm

Time Complexity: O(log n) where n = size of tree. This is a BST and we're performing DFS

Space Complexity: O(1)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // IMPORTANT: In a BST, the left half of the tree will always have nodes that are smaller than the root. Vice versa for the right half.
        TreeNode curNode = root;

        // Traverse BST tree
        while (curNode != null) {

            // If p and q are smaller than curNode, then search left subtree
            if (p.val < curNode.val && q.val < curNode.val) {
                curNode = curNode.left;
            } else if (p.val > curNode.val && q.val > curNode.val) { // If p and q are greater than curNode, then search left subtree
                curNode = curNode.right;
            } else {
                // IMPORTANT: Problem constraint guarantees p and q existing in tree. Therefore, curNode must be either p or q.
                return curNode;
            }
        }

        return curNode; // This will never get triggered but need to satisfy error for missing return statement
    }
}
