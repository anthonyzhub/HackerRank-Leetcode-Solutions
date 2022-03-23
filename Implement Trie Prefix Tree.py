# https://leetcode.com/problems/implement-trie-prefix-tree/

class Node:
    
    # OBJECTIVE: Create a node to build a Trie
    
    def __init__(self):
        self.endOfWord = False
        self.children = dict()

class Trie:

    def __init__(self):
        
        # Create a root node
        self.root = Node()
        

    def insert(self, word: str) -> None:
        
        # OBJECTIVE: Insert a new word into the tree
        
        # If word is empty, exit function
        if word is None:
            return
        
        # Traverse word
        curNode = self.root
        for letter in word:
            
            # Check if a child is already holding the letter
            if letter in curNode.children.keys():
                
                # Update curNode
                curNode = curNode.children[letter]
                
            else:
                
                # Create a new node
                newNode = Node()
                
                # Add newNode to root's children
                curNode.children[letter] = newNode
                
                # Update curNode
                curNode = newNode
                
        # Update boolean variable of curNode
        curNode.endOfWord = True

    def search(self, word: str) -> bool:
        
        # OBJECTIVE: Search for word inside of Trie
        
        # If word is empty, return false
        if word is None:
            return False
        
        # Traverse word
        curNode = self.root
        for letter in word:
            
            # Check if a child is holding the letter
            if letter in curNode.children.keys():
                
                # Move to child node
                curNode = curNode.children[letter]
                
            # If key doesn't exist, then word isn't in trie
            else:
                return False
            
        # If curNode's boolean variable is true, then return true because word does exist inside of Trie
        if curNode.endOfWord:
            return True
        
        return False
        
    def startsWith(self, prefix: str) -> bool:
        
        # OBJECTIVE: Search for prefix inside of Trie
        
        # If prefix is empty, return false
        if prefix is None:
            return False
        
        # Traverse prefix
        curNode = self.root
        for letter in prefix:
            
            if letter in curNode.children.keys():
                curNode = curNode.children[letter]
            else:
                return False
            
        return True
        
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
