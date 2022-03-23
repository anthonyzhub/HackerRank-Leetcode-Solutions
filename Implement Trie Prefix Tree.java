// https://leetcode.com/problems/implement-trie-prefix-tree/

class Node {
    
    public boolean endOfWord = false;
    public HashMap<Character, Node> children = new HashMap<Character, Node>();
}

class Trie {

    Node root;
    public Trie() {
        
        // Create a root node
        root = new Node();
    }
    
    public void insert(String word) {
        
        // OBJECTIVE: Insert word into Trie
        
        // If word is empty, exit function
        if (word == null) {return;}
        
        // Traverse word
        Node curNode = root;
        for (Character letter: word.toCharArray()) {
            
            // Check if letter exist inside of children
            Node child = curNode.children.get(letter);
            
            // If child is null, create a new node and add it to children hash map
            if (child == null) {
                
                // Create a new node
                Node newNode = new Node();
                
                // Add new node to hash map
                curNode.children.put(letter, newNode);
            }
            
            // Move to next node
            curNode = curNode.children.get(letter);
        }
        
        // Update curNode's boolean variable
        curNode.endOfWord = true;
    }
    
    public boolean search(String word) {
        
        // OBJECTIVE: Search for word inside of Trie
        
        // If word is empty, exit function
        if (word == null) {return false;}
        
        // Traverse word
        Node curNode = root;
        for (Character letter: word.toCharArray()) {
            
            // Check if letter exist inside of children
            Node child = curNode.children.get(letter);
            
            // If child is null, then return false because word doesn't exist
            if (child == null) {
                return false;
            }
            
            // If not, then move to child node
            curNode = child;
        }
        
        // If curNode's boolean variable is true, then word does exist inside of Trie
        if (curNode.endOfWord) {return true;}
        return false;
    }
    
    public boolean startsWith(String prefix) {
        
        // OBJECTIVE: Try to find prefix inside of Trie
        
        // If prefix is null, exit function
        if (prefix == null) {return false;}
        
        // Traverse prefix
        Node curNode = root;
        for (Character letter: prefix.toCharArray()) {
            
            // Check if letter exist inside of children
            Node child = curNode.children.get(letter);
            
            // If child is null, return false because prefix doesn't exist
            if (child == null) {return false;}
            
            // If not, move to child
            curNode = child;
        }
        
        // If program is still continuing, then prefix must exist inside of Trie
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
