// https://leetcode.com/problems/minimum-height-trees/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        // If n is less than or equal to 2, return elements from the list.
        // NOTE: This tree will have centroids (nodes at the center) and centroids will always have the shortest tree height
        if (n < 2) {
            
            // Create an array list
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            
            // Populate list with elements from edges
            for (int i=0; i<n; i++) {
                tmp.add(i);
            }
            
            return tmp;
        }
        
        // Create a hash map of neighboring nodes
        ArrayList<HashSet<Integer>> neighbors = new ArrayList<HashSet<Integer>>();
        
        // Add an empty set for each index
        for (int i=0; i<n; i++)
            neighbors.add(new HashSet<Integer>());
        
        // Add every pair to neighbors list
        for (int[] pair: edges) {
            
            // Breakdown pair
            Integer vertexA = pair[0];
            Integer vertexB = pair[1];
            
            // Add pair to hash map
            neighbors.get(vertexA).add(vertexB);
            neighbors.get(vertexB).add(vertexA);
        }
        
        // Collect current leave nodes
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        // Trim the leave nodes until reaching the centroids
        int remainingNodes = n;
        while (remainingNodes > 2) {
            
            // Update remainingNodes by removing leave nodes
            remainingNodes -= leaves.size();
            
            // Create a queue to hold new leaf nodes
            ArrayList<Integer> newLeaves = new ArrayList<Integer>();
            
            // Remove current leaf nodes with edges
            for (Integer leaf: leaves) {
                
                // Get the only neighbor left from the leaf node
                Integer neighbor = neighbors.get(leaf).iterator().next();
                
                // Remove the edge node from the leaf
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            
            // Update leaves with newLeaves
            leaves = newLeaves;
        }
        
        // Return remaining nodes that are centroids
        return leaves;
    }
}
