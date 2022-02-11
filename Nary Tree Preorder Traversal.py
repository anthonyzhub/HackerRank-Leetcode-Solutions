// Link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/

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
        // Exit function if root is empty
        if (root == null)
            return;
        
        // Add root's value to ArrayList
        path.add(root.val);
        
        // Iterate root's children
        for (Node currNode: root.children)
        {
            traverse(currNode, path);
        }
    }
    
    public List<Integer> preorder(Node root) {
        
        // Create an ArrayList
        List<Integer> path = new ArrayList();
        
        // Traverse tree and return ArrayList
        traverse(root, path);
        return path;
    }
}
