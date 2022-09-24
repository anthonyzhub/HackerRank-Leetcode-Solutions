# https://leetcode.com/problems/top-k-frequent-elements/

from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # Convert list to a dictionary
        dic = Counter(nums)
        
        # Sort dictionary by value
        # NOTE: sorted() will return a list of tuples
        dic = sorted(dic.items(), key= lambda x:x[1], reverse=True)
        
        # Iterate list
        res = list()
        for elem in dic:
            
            # Get the 1st k values
            if k > 0:
                
                # Subtract k and add key to res
                k -= 1
                res.append(elem[0])
                
        return res
