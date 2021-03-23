# Link: https://leetcode.com/problems/isomorphic-strings/submissions/

class Solution:
    
    def stringToDict(self, s: str):
        
        # Create a dictionary
        sDict = dict()
        
        # Iterate string
        for idx, i in enumerate(s):
            
            # Add key to dictionary or update key's value
            if i in sDict.keys():
                sDict[i] += [idx]
            else:
                sDict[i] = [idx]
                
        return sDict
        
    def valuesToList(self, sDict):
        
        # create a list
        sList = list()
        
        # Add all key's values to list
        for v in sDict.values():
            sList.append(v)
            
        return sList
    
    def isIsomorphic(self, s: str, t: str) -> bool:
        
        # Return true, if both strings are NoneType
        if s == None and t == None:
            return True
        
        # Return true, if both strings are empty
        if len(s) <= 0 and t <= 0:
            return True
        
        # Turn both strings into dictionaries
        sDict = self.stringToDict(s)
        tDict = self.stringToDict(t)
        
        # Separate values from dictionary
        sList = self.valuesToList(sDict)
        tList = self.valuesToList(tDict)
        
        # Check if both lists are the same
        if sList == tList:
            return True
        
        return False
