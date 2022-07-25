// https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/
// Reference: https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/2111643/Java-or-Dijkstra-or-Optimized-or-Easy-Understanding

class Solution {
    
    public void buildGraph(int[][] flights, HashMap<Integer, List<int[]>> graph) {
        
        // OBJECTIVE: Populate graph with flight information
        
        for (int[] flight: flights) {
            
            // Parse and label data
            int source = flight[0];
            int dest = flight[1];
            int cost = flight[2];
            
            // If key doesn't exist, create a new entry
            graph.putIfAbsent(source, new ArrayList<>());
            
            // Update list with associated key
            graph.get(source).add(new int[] {dest, cost});
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Create a graph
        HashMap<Integer, List<int[]>> graph = new HashMap();
        buildGraph(flights, graph);
        
        // Create a priority queue with overwritten comparison function
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        // Add initial data to pq
        minHeap.add(new int[] {src, 0, 0});
        
        // Create a HashMap to keep track of visited nodes
        HashMap<Integer, Integer> visited = new HashMap<>();
        
        // Traverse pq
        while (!minHeap.isEmpty()) {
            
            // Pop 1st element from pq
            int[] popped = minHeap.poll();
            
            // Parse and label data
            int city = popped[0];
            int cost = popped[1];
            int stops = popped[2];
            
            // If city hasn't been visited before or the # of stops is less than previous visit, update log. If not, move to next flight plan
            if (!visited.containsKey(city) || stops < visited.get(city)) {
                visited.put(city, stops);
            }
            else {
                continue;
            }
            
            // If city is destination, return cost
            if (city == dst) {return cost;}
            
            // If # of stops has exceeds k or there aren't any adjacent visited, then move to next flight plan
            if (stops > k || !graph.containsKey(city)) {continue;}
            
            // Iterate through all adjacent nodes from current node
            for (int[] adjCity: graph.get(city)) {
                minHeap.add(new int[] {adjCity[0], cost + adjCity[1], stops + 1});
            }
        }
        return -1;
    }
}
