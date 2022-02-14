// Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    public List<List<Integer>> levelOrder(Node root) {
        
        // Create a list as a return value for function
        List<List<Integer>> finalList = new ArrayList<>();
        
        // If root is empty, return empty list
        if (root == null) { return finalList; }
        
        // Create a queue to hold incoming children nodes
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        // Iterate queue
        while (queue.isEmpty() == false)
        {
            int queueSize = queue.size();
            
            // Create a temporary list
            List<Integer> currentLevel = new ArrayList();
            
            // Iterate queue (again)
            for(int i=0; i<queueSize; i++)
            {
                // Pop head element
                Node currNode = queue.remove();
                
                // Add root's value to list
                currentLevel.add(currNode.val);
                
                // Iterate currNode's children
                for (Node child: currNode.children)
                {
                    queue.add(child);
                }
            }
            
            // Add temporary list to finalList
            finalList.add(currentLevel);
        }
        return finalList;
    }
}
