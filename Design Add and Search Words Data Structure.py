# https://leetcode.com/problems/design-add-and-search-words-data-structure/

class Node:
    
    def __init__(self):
        self.endOfWord = False
        self.children = dict()

class WordDictionary:

    def __init__(self):
        
        # Create a root node
        self.root = Node()

    def addWord(self, word: str) -> None:
        
        # OBJECTIVE: Add word to Trie letter by letter
        
        # If word is empty, exit string
        if word is None:
            return
        
        # Iterate word
        curNode = self.root
        for letter in word:
            
            # Check if letter is inside of children
            if letter in curNode.children.keys():
                
                # Update node
                curNode = curNode.children[letter]
                
            else:
                
                # Create a new node
                newNode = Node()
                
                # Add new node to children dictionary
                curNode.children[letter] = newNode
                
                # Update curNode
                curNode = newNode
                
        # Update boolean variable
        curNode.endOfWord = True
        
    def customSearch(self, root, word, idx):
        
        # OBJECTIVE: Search for word inside Trie
        
        # If index is at end of word, return root's endOfWord status
        if idx == len(word):
            return root.endOfWord
        
        # Get letter
        letter = word[idx]
        
        # If letter at index is held by root's children, make a recursive call
        if letter in root.children.keys():
            return self.customSearch(root.children[letter], word, idx + 1)
        
        # If letter is actually a dot, check if next letter is held by root's descendants
        if letter == ".":
            
            # Create a list to hold response from each child
            results = list()
            for child in root.children.values():
                results.append(self.customSearch(child, word, idx + 1))
                
            # If any element inside of "result" is true, return it
            if True in results:
                return True
            
            return False
            
            # Does the same thing as above, except it's 1 second faster (yes) and uses 100 kB less
            # return any(self.customSearch(child, word, idx + 1) for child in root.children.values())
    
    def search(self, word: str) -> bool:
        return self.customSearch(self.root, word, 0)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
