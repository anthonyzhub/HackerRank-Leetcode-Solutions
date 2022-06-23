// https://leetcode.com/problems/course-schedule/

class Solution {
    
    public boolean bfs(int startingNode, HashMap<Integer, ArrayList<Integer>> graph, LinkedList<Integer> queue) {
        
        // Create a hash set of nodes that were visited
        HashSet<Integer> visited = new HashSet<Integer>();
        
        // Iterate queue and look for a cycle
        while (queue.size() != 0) {
            
            // Pop head node
            int poppedNode = queue.pop();
            visited.add(poppedNode);
            
            // Check if poppedNode exist in graph
            if (graph.containsKey(poppedNode)) {
                
                // Go through poppedNode's adjacent nodes
                for (int adjNode: graph.get(poppedNode)) {
                    
                    // If adjacent node is the starting node, then a cycle exist so return false
                    if (startingNode == adjNode) {return false;}
                    
                    // If adjacent node wasn't visited before, add it to queue
                    if (!visited.contains(adjNode)) {
                        queue.add(adjNode);
                    }
                }
            }
        }
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        /*
        * OBJECTIVE: Return true if user can finish all courses inside of prerequisites
        *
        * Time Complexity: O(P + K*( V + E)) where P = length of prerequisites, K = length of graph, V + E = # of vertices and edges inside graph. 
        *
        *                   O(P) comes from the 1st for-loop where I add all elements from prerequisites[] to graph[]. 
        *
        *                   O(K * (V+E)) comes from the 2nd for-loop where I go through all the entries inside of the graph. Per entry, breadth-first search
        *                   is used to check if a cycle exists.
        *
        * Space Complexity: O(V + E) where V = # of vertices and E = # of edges. The graph will store all the prerequsiite courses as a key and link the course to take as values. 
        *                   Visited[] will hold all the vertices that I have visited inside the graph and queue[] will hold them temporarily until they're popped.
        */
        
        // Create a graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        
        // Populate graph with elements from prerequisites
        for (int[] course: prerequisites) {
            
            // Break down course to a node and adjacent nodes
            int node = course[0];
            int adjNode = course[1];
            
            // Add data to graph
            if (graph.containsKey(node)) {
                graph.get(node).add(adjNode);
            }
            else {
                
                // Create a temporary list
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(adjNode);
                
                // Add new key to graph
                graph.put(node, tmpList);
            }
        }
        
        // Iterate graph
        for (int node: graph.keySet()) {
            
            // Create a queue
            LinkedList<Integer> queue = new LinkedList<Integer>();
            queue.add(node);
            
            // If a cycle is detected, return false
            if (bfs(node, graph, queue) == false) {
                return false;
            }
        }
        return true;
    }
}
