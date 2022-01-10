# https://leetcode.com/problems/compare-version-numbers/

class Solution:
    
    def splitNumbers(self, versionNumber):
        
        # OBJECTIVE: Split string into a list with "." as delimiter
        
        newList = list()
        for c in versionNumber.split("."):
            newList.append(int(c))
            
        return newList
    
    def compareVersion(self, version1: str, version2: str) -> int:
        
        # Split string
        version1 = self.splitNumbers(version1)
        version2 = self.splitNumbers(version2)
        
        # Get length of longest string
        maxLength = max(len(version1), len(version2))
        
        # Iterate both lists
        for i in range(maxLength):
            
            # Get next digit. If either list ended first, just use 0
            if i < len(version1):
                v1_num = version1[i]
            else:
                v1_num = 0
            
            if i < len(version2):
                v2_num = version2[i]
            else:
                v2_num = 0
            
            # Compare both digits
            if v1_num > v2_num:
                return 1
            
            elif v1_num < v2_num:
                return -1
            
        # If condition above wasn't met, return 0
        return 0
