// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
    
    // Declare class variable
    TreeNode res;
    
    public Solution() {
        res = null;
    }
    
    public boolean traverseTree(TreeNode root, TreeNode p, TreeNode q) {
        
        // OBJECTIVE: Traverse tree and return a boolean indicating whether or not p and q nodes were found
        
        // If root is empty, exit function
        if (root == null) {return false;}
        
        // Set true if p or q equals to root
        boolean curNode = (root == p || root == q);
        
        // Set true if p or q is in root's left subtree
        boolean leftSubtree = traverseTree(root.left, p, q);
        
        // Set true if p or q is in root's right subtree
        boolean rightSubtree = traverseTree(root.right, p, q);
        
        // If p and q nodes were found, set res node as common ancestor
        /*
        * curNode & leftSubtree => If p or q is root node and the other node is descendant of current root, set res node as current root
        * curNode & rightSubtree => If p or q is root node and the other node is descendant of current root, set res node as current root
        * leftSubtree & rightSubtree => If p and q were found in root's left and right subtrees, set res as current root
        */
        if ((curNode && leftSubtree) || (curNode && rightSubtree) || (leftSubtree && rightSubtree)) {
            res = root;
        }
        
        // Return boolean variable indicating whether or not p and q were found
        return curNode || leftSubtree || rightSubtree;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      
        // OBJECTIVE: Return the lowest common ancestor of nodes p and q
        
        // If root is null, exit function
        if (root == null) {return null;}
        
        // If root equals to either p or q, return it as lowest common ancestor
        if (root == p || root == q) {return root;}
        
        // Traverse tree and return res node
        traverseTree(root, p, q);
        return res;
    }
}
