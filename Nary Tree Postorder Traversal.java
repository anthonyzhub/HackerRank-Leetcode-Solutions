// Link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/

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
    
    public void traverse(Node root, List<Integer> path)
    {
        // If root is empty, exit function
        if (root == null) { return; }
        
        // Vist root's children first
        for (Node currNode: root.children)
        {
            traverse(currNode, path);
        }
        
        // Finally add root's value to list
        path.add(root.val);
    }
    
    public List<Integer> postorder(Node root) {
        // Postorder: Left, right, root
        
        List<Integer> path = new ArrayList();
        traverse(root, path);
        return path;
    }
}
