// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    
    public void traverseTree(TreeNode root, ArrayList<Integer> kElems, int k) {
        
        // If root is null, exit function
        if (root == null) {return;}
        
        // If list is already full and root's value is smaller than larget number, replace largest number with root's value
        if (kElems.size() == k && kElems.get(k-1) > root.val) {
            kElems.remove(k - 1);
        }
        
        // Add root's value to list
        kElems.add(root.val);
        Collections.sort(kElems);
        
        // Visit children
        traverseTree(root.left, kElems, k);
        traverseTree(root.right, kElems, k);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        
        // If root doesn't have any children, return its value
        if (root.left == null && root.right == null) {return root.val;}
        
        // Create a list of size k
        ArrayList<Integer> kElems = new ArrayList();
        
        // Traverse tree
        traverseTree(root, kElems, k);
        
        // Return Kth element (last element) inside list
        return kElems.get(k-1);
    }
}
