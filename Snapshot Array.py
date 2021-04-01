# Link: https://leetcode.com/problems/snapshot-array/submissions/

"""
NOTE: I used a dictionary because it has a lookup time of O(1). Without using a dictionary,
        Leetcode would have raised a "Time Limit Exceeded" error.
"""

from copy import deepcopy
from collections import defaultdict

class SnapshotArray:

    def __init__(self, length: int):
        
        # OBJECTIVE: Create a list of N size with a default value of 0
        
        # Create a counter to count how many times snap() was called
        self.timesSnapCalled = 0
        
        # Create a dictionary that holds previously created dictionaries
        self.arrayHistory = dict()
        
        # Create a dictionary for current use
        self.array = dict()

    def set(self, index: int, val: int) -> None:
        # OBJECTIVE: Update value of element at specified index
        self.array[index] = val
        
    def snap(self) -> int:
        # OBJECTIVE: Make a copy of the array and return ID number
        
        # Make copy of current dictionary and add it to history
        # NOTE: deepcopy() was used to create a copy, instead of storing a reference
        self.arrayHistory[self.timesSnapCalled] = deepcopy(self.array)
        
        # Increment timesSnapCalled
        self.timesSnapCalled += 1
        
        return self.timesSnapCalled - 1
    
    def get(self, index: int, snap_id: int) -> int:
        # OBJECTIVE: Return value of element at index of specified array
        
        # Return element of oldArray
        # NOTE: get() returns value at key. If key doesn't exist, return 0
        return self.arrayHistory[snap_id].get(index, 0)
