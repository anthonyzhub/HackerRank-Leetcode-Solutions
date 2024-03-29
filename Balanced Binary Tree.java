// https://leetcode.com/problems/balanced-binary-tree/
// https://www.youtube.com/watch?v=QfJsau0ItOY

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

    private Pair<Boolean, Integer> dfs(TreeNode root) {

        // If root is a leaf node, then exit function
        // NOTE: A leaf node is automatically a balanced subtree and has a height of 0
        if (root == null) {
            return new Pair<Boolean, Integer>(true, 0);
        }

        // Check root's left and right subtree
        Pair<Boolean, Integer> leftSubtree = dfs(root.left);
        Pair<Boolean, Integer> rightSubtree = dfs(root.right);

        // If both subtrees are balanced and their height difference isn't greater than 1, then root has a height balance
        //
        // IMPORTANT: If isTreeBalanced becomes false, that will affect all future boolean calulations.
        // I.e., if a subtree doesn't have a height balance, then the entire tree doesn't have a height balance
        Boolean isTreeBalanced;
        if (leftSubtree.getKey() && rightSubtree.getKey() && Math.abs(leftSubtree.getValue() - rightSubtree.getValue()) <= 1) {
            isTreeBalanced = true;
        }
        else {
            isTreeBalanced = false;
        }

        // Return result to parent of root
        return new Pair<Boolean, Integer>(isTreeBalanced, 1 + Math.max(leftSubtree.getValue(), rightSubtree.getValue()));
    }

    public boolean isBalanced(TreeNode root) {

        /*
         * Time Complexity: O(n) where n = number of nodes inside the tree. Every node is being inspected
         * 
         * Space Complexity: O(n) where n = number of recursive calls, which is influenced by the number
         *  of nodes inside the tree.
         */
        
        // If root is null, then tree is balanced
        if (root == null) {
            return true;
        }

        // Use dfs() to check if tree is balanced
        // Pair: (isTreeBalanced, height difference between root's subtrees)
        Pair<Boolean, Integer> result = dfs(root);

        return result.getKey();
    }
}