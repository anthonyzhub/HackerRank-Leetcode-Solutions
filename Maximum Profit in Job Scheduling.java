// https://leetcode.com/problems/maximum-profit-in-job-scheduling/

class Node implements Comparable<Node> {
    
    int startTime;
    int endTime;
    int profit;
    
    public Node(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
    
    @Override
    public int compareTo(Node against) {
        
        // OBJECTIVE: Override compareTo() to sort nodes in custom order
        
        if (this.endTime > against.endTime) {
            return 1;
        }
        else if (this.endTime < against.endTime) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

class Solution {
    
    public int binarySearch(ArrayList<Node> nodes, Node curNode, int startPtr, int endPtr) {
        
        // OBJECTIVE: Return index of node with earliest end time
        
        while (startPtr <= endPtr) {
            
            // Get middle node
            int midPtr = (int) (startPtr + endPtr) / 2;
            Node midNode = nodes.get(midPtr);
            
            // If midNode.endTime is less than or equal to curNode.startTime, move to right-half of the list
            if (midNode.endTime <= curNode.startTime) {
                startPtr = midPtr + 1;
            }
            
            // If midNode.endTime is greater than curNode.startTime, move to left-half of the list
            else {
                endPtr = midPtr - 1;
            }
        }
        
        return endPtr;
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        // Calculate number of jobs there are:
        // NOTE: All arrays will always share the same size
        int numOfJobs = startTime.length;
        
        // Create a list of nodes
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i=0; i<startTime.length; i++) {
            
            // Create a new node
            Node newNode = new Node(startTime[i], endTime[i], profit[i]);
            nodes.add(newNode);
        }
        
        // Sort list by end time
        Collections.sort(nodes);
        
        // Create a list of total profits made based on jobs
        int[] totalProfit = new int[numOfJobs];
        
        // Make combinations
        for (int i=0; i<numOfJobs; i++) {
            
            // Get index of node with earliest end time
            int profitIdx = binarySearch(nodes, nodes.get(i), 0, i - 1);
            
            // Get profit that was previously made with that node from binarySearch()
            int preProfit = 0;
            if (profitIdx != -1) {
                preProfit = totalProfit[profitIdx];
            }
            
            // Keep maximum profit
            // NOTE: Add if-condition because Java doesn't support -1 indexing
            if (i - 1 < 0) {
                totalProfit[i] = Math.max(totalProfit[0], nodes.get(i).profit + preProfit);
            } else {
                totalProfit[i] = Math.max(totalProfit[i - 1], nodes.get(i).profit + preProfit);
            }
        }
        
        return totalProfit[totalProfit.length - 1];
    }
}
