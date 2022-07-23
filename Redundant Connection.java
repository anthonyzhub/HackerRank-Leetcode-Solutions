// https://leetcode.com/problems/redundant-connection/

class Solution {
    
    public boolean dfs(HashMap<Integer, HashSet<Integer>> graph, int start, int end, HashSet<Integer> visited) {
        
        // OBJECTIVE: Return boolean variable indicating whether or not start and end nodes are connected to each other
        
        // Check if start hasn't been visited yet
        if (!visited.contains(start)) {
            
            // Add start node to set
            visited.add(start);
            
            // If start node equals to end, return true
            if (start == end) {return true;}
            
            // Visit start node's neighbors
            for (int neighbor: graph.get(start)) {
                
                // If a dfs returns true, return it immediately
                if (dfs(graph, neighbor, end, visited) == true) {return true;}
            }
        }
        return false;
    }
    
    public void addOrUpdateKey(HashMap<Integer, HashSet<Integer>> graph, int key, int value) {
        
        // OBJECTIVE: Create or update key in graph
        
        // If key already exist, update set
        if (graph.containsKey(key)) {
            graph.get(key).add(value);
        }
        
        // If key doesn't exist, create a new set and key
        else {
            
            // Create a temporarily set
            HashSet<Integer> tmpSet = new HashSet<Integer>();
            tmpSet.add(value);
            
            // Create a new key
            graph.put(key, tmpSet);
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        /*
        * OBJECTIVE: Return an edge that can be removed so that the resulting graph is a gree of "n" nodes
        *
        * Time Complexity: O(N^2) where N = # of vertices and edges inside the graph
        *
        * Space Complexity: O(N) where N = # of nodes insde the graph. A graph has to be constructed with N nodes
        */
        
        // Create a graph
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        
        // Create an output array
        int[] output = new int[2];
        
        // Iterate edges matrix
        for (int[] edge: edges) {
            
            // Create a set for visited nodes
            HashSet<Integer> visited = new HashSet<Integer>();
            
            // Parse and label elements
            int start = edge[0];
            int end = edge[1];
            
            // Check if start and end exist inside of graph and that dfs() returns true
            if (graph.containsKey(start) && graph.containsKey(end) && dfs(graph, start, end, visited)) {
                
                // Return array
                return edge;
            }
            
            // Add start and end node to graph
            addOrUpdateKey(graph, start, end);
            addOrUpdateKey(graph, end, start);
        }
        return output;
    }
}
