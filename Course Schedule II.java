// https://leetcode.com/problems/course-schedule-ii/

class Solution {
    
    // Create variables for labelling nodes
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
    
    // Create class variables
    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjacencyList;
    List<Integer> topologicalOrder;
    
    private void initialize(int numCourses) {
        
        // Update class variables
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjacencyList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();
        
        // Set all nodes to WHITE
        for (int i=0; i<numCourses; i++) {
            color.put(i, WHITE);
        }
    }
    
    public void dfs(int node) {
        
        // If boolean variable is false, then a cycle was detected
        if (!isPossible) {return;}
        
        // Start recursion and set node's color to GRAY
        color.put(node, GRAY);
        
        // Traverse neighboring nodes
        for (Integer neighboringNode: adjacencyList.getOrDefault(node, new ArrayList<Integer>())) {
            
            // If neighboringNode is marked as WHITE, perform dfs() from neighboring node
            if (color.get(neighboringNode) == WHITE) {
                dfs(neighboringNode);
            }
            
            // If neighboringNode is marked as GRAY, then a cycle was detected
            else if (color.get(neighboringNode) == GRAY) {
                isPossible = false;
            }
        }
        
        // After recursion ends and no cycle was detected, mark node as BLACK
        color.put(node, BLACK);
        topologicalOrder.add(node);
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // Create class variables
        initialize(numCourses);
        
        // Populate adjancencyList
        for (int[] item: prerequisites) {
            
            // Parse data
            int node = item[0];
            int adjNode = item[1];
            
            // Get list from hash map if it exists
            List<Integer> tmpList = adjacencyList.getOrDefault(adjNode, new ArrayList<Integer>());
            
            // Add new node to list and then to adjacency list
            tmpList.add(node);
            adjacencyList.put(adjNode, tmpList);
        }
        
        // Perform dfs() on nodes marked as WHITE
        for (int i=0; i<numCourses; i++) {
            if (color.get(i) == WHITE) {dfs(i);}
        }
        
        // If a cycle wasn't detected, insert courses to array in order
        int[] order;
        if (isPossible) {
            
            // Set order's size to be numCourses
            order = new int[numCourses];
            
            // Populate order
            for (int i=0; i<numCourses; i++) {
                order[i] = topologicalOrder.get(numCourses - i - 1);
            }
        }
        
        // If a cycle was detected, set order as a blank array
        else {
            order = new int[0];
        }
        
        return order;
    }
}
