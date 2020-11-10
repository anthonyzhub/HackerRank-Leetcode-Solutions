# Link: https://leetcode.com/problems/lru-cache/submissions/

class LRUCache:

    # OBJECTIVE: Remove least recently used element
    
    def __init__(self, capacity: int):
        
        self.capacity = capacity
        self.lruDict = dict()
        self.stack = list()

    def get(self, key: int) -> int:
        
        # Check if key exists inside dictionary.
        # Stack and dictionary shares same keys
        if key in self.lruDict.keys():
            
            # Remove and re-insert key from stack
            self.stack.remove(key)
            self.stack.append(key)
            
            # Return value
            return self.lruDict[key]
        
        return -1

    def put(self, key: int, value: int) -> None:
        
        # If key already exists, then dictionary's size won't change.
        # So, update it's value
        if key in self.stack:
            
            # Update stack
            self.stack.remove(key)
            self.stack.append(key)
        
            # Update key's value
            self.lruDict[key] = value
            
            # Exit function
            return
        
        # If key doesn't exist and capacity is already met, delete oldest key
        if self.capacity < len(self.lruDict.keys()) + 1:
            
            # Remove 1st element from stack and delete key
            oldKey = self.stack.pop(0) # NOTE: pop(-1) is set as default
            del self.lruDict[oldKey]
        
            # Add new key to dictionary and stack
            self.lruDict[key] = value
            self.stack.append(key)
            
        else:
            
            # If key doesn't exist and capacity isn't met, then add new key to stack and dictionary
            self.stack.append(key)
            self.lruDict[key] = value

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
