/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
https://youtu.be/6ZnyEApgFYg?si=SqHadFk7WFyrsbZ8

Time Complexity: O(n) where n = # of nodes inside tree

Space Complexity: O(n) where n = # of nodes inside tree. All nodes are added to the result
*/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // Create a queue and add root to it
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Iterate queue
        while (!queue.isEmpty()) {

            // Get length of queue because ideally it will only hold all the elements on the same level at a time
            int queueLen = queue.size();

            // Create a Level array
            List<Integer> level = new ArrayList<>();

            // Iterate all the children nodes
            for (int i = 0; i < queueLen; i++) {

                // Pop element from queue
                // NOTE: We haven't done it yet
                TreeNode poppedElem = queue.remove();

                // If popped node isn't empty, then add its value to level and its children to the queue
                if (poppedElem != null) {
                    level.add(poppedElem.val);
                    
                    // Some nodes don't have children, so if-condition will prevent level from having null values to begin with
                    queue.add(poppedElem.left);
                    queue.add(poppedElem.right);
                }
            }

            // If Level isn't empty, then add it to the list
            // IMPORTANT: Some nodes 
            if (!level.isEmpty()) {
                result.add(level);
            }
        }

        return result;
    }
}
