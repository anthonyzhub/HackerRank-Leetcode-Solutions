# https://leetcode.com/problems/random-pick-with-blacklist/

from random import choice
class Solution:

    def __init__(self, target: int, blacklist: List[int]):
        
        # Save parameters
        blacklist = set(blacklist)  # NOTE: Set() has a faster search time
        self.N = target - len(blacklist)
        
        # Create a dictionary
        # NOTE: Key is number and value is index
        key = list()
        for i in blacklist:
            if i < self.N:
                key.append(i)
                
        val = list()
        for i in range(self.N, target):
            if i not in blacklist:
                val.append(i)
                
        # Zip both list together and convert it into a dictionary
        self.dic = dict(zip(key, val))

    def pick(self) -> int:
        
        # Select a random integer
        i = randint(0, self.N-1)
        
        # Return key's value or i if key doesn't exist
        return self.dic.get(i, i)


# Your Solution object will be instantiated and called as such:
# obj = Solution(n, blacklist)
# param_1 = obj.pick()
