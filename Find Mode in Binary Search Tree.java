// https://leetcode.com/problems/find-mode-in-binary-search-tree/

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

import java.util.*;

class Solution {
    
    public void traverseTree(TreeNode root, HashMap<Integer, Integer> nodes_hashmap) {
        
        // OBJECTIVE: Add root to hash map and update its number of occurrences
        
        // If root is null, exit function
        if (root == null) {return;}
        
        // Add node to hash map
        if (nodes_hashmap.containsKey(root.val)) {
            nodes_hashmap.put(root.val, nodes_hashmap.get(root.val) + 1);
        }
        else {
            nodes_hashmap.put(root.val, 1);
        }
        
        // Visit left and right children
        traverseTree(root.left, nodes_hashmap);
        traverseTree(root.right, nodes_hashmap);
    }
    
    public int[] findMode(TreeNode root) {
        
        // If root is null, exit function
        if (root == null) {
            
            int[] tmpNode = new int[1];
            return tmpNode;
        }
        
        // If root doesn't have any kids, return its value
        if (root.left == null && root.right == null) {
            
            // Create an array
            int[] tmpArray = {root.val};
            return tmpArray;
        }
        
        // Create a HashMap
        HashMap<Integer, Integer> nodes_hashmap = new HashMap();
        
        // Traverse tree
        traverseTree(root, nodes_hashmap);
        
        // Get maximum value in hash map
        int max_value = Collections.max(nodes_hashmap.values());
        
        // Look for keys that holds the maximum value
        ArrayList<Integer> popular_nodes = new ArrayList();
        for (Integer nodeVal: nodes_hashmap.keySet()) {
            
            // If key's value matches max_value, add key to array
            if (nodes_hashmap.get(nodeVal) == max_value) {
                popular_nodes.add(nodeVal);
            }
        }
        
        // Convert array list to an array
        int[] answer = new int[popular_nodes.size()];
        int idx = 0;
        for (Integer nodeVal: popular_nodes) {
            answer[idx] = nodeVal;
            idx++;
        }
        
        return answer;
    }
}
