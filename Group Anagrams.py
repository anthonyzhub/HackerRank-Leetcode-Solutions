# Link: https://leetcode.com/problems/group-anagrams/submissions/

from collections import defaultdict

class Solution(object):
    
    """
        :type strs: List[str]
        :rtype: List[List[str]]
    """
        
    def groupAnagrams(self, strs):
        
        # If list is empty, return an empty list
        if strs is None:
            return [[]]
        
        # Create a dictionary with a default value of an empty list
        # E.g. {string: list}
        ansDict = defaultdict(list)
        
        # Iterate list
        for word in strs:
            
            # Take string and sort it as a tuple
            tupleStr = tuple(sorted(word))
            
            # If tupleStr exist as a key, add "word" to the list acting as a value
            # If not, add it as a key and add new "word" to its list
            ansDict[tupleStr].append(word)
        
        # Only return the group of anagrams
        return ansDict.values()
