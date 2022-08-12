# https://leetcode.com/problems/smallest-number-in-infinite-set/

import heapq

class SmallestInfiniteSet:
    
    def __init__(self):
        
        # Create a heap and a set
        self.heap = list()
        self.set = set()
        
        # Create a variable to hold the smallest number
        self.smallestNum = 1

    def popSmallest(self) -> int:
        
        # OBJECTIVE: Return smallest element from heap and set
        
        # Check if heap isn't empty
        if self.heap:
            
            # Pop element from heap and set
            popped = heapq.heappop(self.heap)
            self.set.remove(popped)
            
            # Return popped element
            return popped
        
        # If heap is empty, return smallest number based on variable
        # NOTE: smallestNum needs to be updated before returned
        self.smallestNum += 1
        return self.smallestNum - 1

    def addBack(self, num: int) -> None:
        
        # If num is smaller than smallest and it doesn't exist in set, add it to set and heap
        if num < self.smallestNum and num not in self.set:
            self.set.add(num)
            heapq.heappush(self.heap, num)

# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)
