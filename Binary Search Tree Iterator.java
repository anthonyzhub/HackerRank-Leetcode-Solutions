// https://leetcode.com/problems/binary-search-tree-iterator/

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

class BSTIterator {

    // Create an ArrayList
    ArrayList<TreeNode> nodes = new ArrayList();
    int idx = 0;
    
    public BSTIterator(TreeNode root) {
        
        // Traverse tree and add nodes to list
        traverseTree(root, nodes);
        System.out.println(nodes);
    }
    
    public void traverseTree(TreeNode root, ArrayList<TreeNode> nodes) {
        
        // Exit if root is null
        if (root == null) {
            return;
        }
        
        // Traverse tree in inorder (left, root, right)
        traverseTree(root.left, nodes);
        nodes.add(root);
        traverseTree(root.right, nodes);
    }
    
    public int next() {
        
        // Save current node's value then increment idx
        int curVal = nodes.get(idx).val;
        idx++;
        return curVal;
    }
    
    public boolean hasNext() {
        
        // If idx hasn't reached to the end of the list yet, return true
        if (idx < nodes.size()) {
            return true;
        }
        
        // If condition above wasn't met, return false
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
