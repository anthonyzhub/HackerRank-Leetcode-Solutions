# https://leetcode.com/problems/insert-delete-getrandom-o1/

from random import choice

class RandomizedSet:

    def __init__(self):
        
        # Create a set
        # NOTE: A set was used because all operations take O(1) time
        self.curSet = set()
        

    def insert(self, val: int) -> bool:
        
        # OBJECTIVE: Insert val in O(1) time
        
        # If element already exist, return true
        if val in self.curSet:
            return False
        
        # Add element to set and return false
        self.curSet.add(val)
        return True

    def remove(self, val: int) -> bool:
        
        # OBJECTIVE: Remove val from set in O(1) time
        
        # If element exist, return true
        if val in self.curSet:
            
            # Create a new set
            self.curSet = self.curSet.difference(set([val]))
            return True
        
        return False

    def getRandom(self) -> int:
        
        # OBJECTIVE: Return a random value from set
        return choice(list(self.curSet))


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
