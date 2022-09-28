# https://leetcode.com/problems/shuffle-an-array/

from random import randint

class Solution:

    def __init__(self, nums: List[int]):
        
        # Save nums in class
        # NOTE: This is for better_shuffle() where elements are swapped within the list
        self.nums = nums
        
        # Pass all elements from nums to orig
        self.orig = nums[:]
        
        # Get size of list
        self.n = len(nums)
        
    def reset(self) -> List[int]:
        
        # OBJECTIVE: Return original list
        return self.orig

    def shuffle(self) -> List[int]:
        
        """
        OBJECTIVE: Use combination() to return a shuffled list
        Time Complexity: O(n * r) where n = self.n and r = how many times the inner while-loop runs.
        Space Complexity: O(n) where n = length of popped. The size varies based on the nums' size
        """
        
        # Create a return list
        shuffled = list()
        
        # Create a boolean list
        popped = [False] * self.n
        
        # Iterate range
        for i in range(self.n):
            
            # Select a random index
            randIdx = randint(0, self.n - 1)
            
            # If element at randIdx is true, select another number
            while popped[randIdx]:
                randIdx = randint(0, self.n - 1)
            
            # Pop element from self.orig and set element to True in popped
            shuffled.append(self.orig[randIdx])
            popped[randIdx] = True
            
        return shuffled
    
    def better_shuffle(self) -> List[int]:
        
        """
        OBJECTIVE: Use Fisher-Yates algorithm to create a better shuffle function
        Time Complexity: O(n) where n = self.n
        Space Complexity: O(1) because no additional space was created for this function
        """
        
        # Iterate nums
        for curIdx in range(self.n):
            
            # Generate random index
            # NOTE: Can also use randrange()
            randIdx = randint(0, self.n - 1)
            
            # Swap elements from curIdx and randIdx
            self.nums[curIdx], self.nums[randIdx] = self.nums[randIdx], self.nums[curIdx]
            
        return self.nums

# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()
