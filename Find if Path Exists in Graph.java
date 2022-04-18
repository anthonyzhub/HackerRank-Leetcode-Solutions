// https://leetcode.com/problems/find-if-path-exists-in-graph/

class Solution {
    
    public void addEntry(HashMap<Integer, ArrayList<Integer>> neighboringVertices, int key, int newValue) {
        
        // OBJECTIVE: Update hash map with new value at key
        
        // If key already exist, update value
        if (neighboringVertices.containsKey(key)) {
            
            // Add new element to key's value, which is an array
            neighboringVertices.get(key).add(newValue);
            return; // Exit function
        }
        
        // Create an array for new key
        ArrayList<Integer> tmpArray = new ArrayList();
        tmpArray.add(newValue);
        
        // Add key to hash map
        neighboringVertices.put(key, tmpArray);
    }
    
    public void populateMap(int[][] edges, HashMap<Integer, ArrayList<Integer>> neighboringVertices) {
        
        // OBJECTIVE: Populate hash map with vertices from "edges".
        // E.g., vertex: {vertex's connecting neighbors}
        
        // Traverse edges and add all vertices to hash map
        for (int[] curVertex: edges) {
            
            // Get vertex's source and destination
            int tmpSource = curVertex[0];
            int tmpDest = curVertex[1];
            
            // Add or update vertices to hash map
            // NOTE: tmpSource and tmpDest has their own neighbors
            addEntry(neighboringVertices, tmpSource, tmpDest);
            addEntry(neighboringVertices, tmpDest, tmpSource);
        }
    }
    
    public void iterateHashMap(HashMap<Integer, ArrayList<Integer>> neighboringVertices, HashSet<Integer> visitedVertices, int source) {
        
        // OBJECTIVE: Go through every vertex and its neighbors without visiting the same vertex
        
        // Add source to visitedVertices
        visitedVertices.add(source);
        
        // Go through source's neighbors
        // NOTE: get() will return an ArrayList, so in reality, I'm traversing an ArrayList
        for (int curNeighbor: neighboringVertices.get(source)) {
            
            // If curNeighbor hasn't been visited before, check out its neighbors
            if (!visitedVertices.contains(curNeighbor)) {
                iterateHashMap(neighboringVertices, visitedVertices, curNeighbor);
            }
        }
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        // If graph is empty, return true
        if (edges == null || edges.length == 0) {return true;}
        
        // Create a hash map to hold vertices and its neighbors
        HashMap<Integer, ArrayList<Integer>> neighboringVertices = new HashMap();
        populateMap(edges, neighboringVertices);
        
        // After adding all vertices to hash map, visit each vertex and their neighbors
        HashSet<Integer> visitedVertices = new HashSet();
        iterateHashMap(neighboringVertices, visitedVertices, source);
        
        // If destination is inside visistedVertices, then path to destination exist
        if (visitedVertices.contains(destination)) {return true;}
        
        return false;
    }
}
