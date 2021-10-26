# https://leetcode.com/problems/restore-ip-addresses/submissions/

class Solution:
    
    def backTrack(self, s, currIdx, numOfDots, currIP, finalList):
        
        # If all 4 dots were used and index will go out-of-bounds, exit function
        if numOfDots == 4 and len(s) == currIdx:
            
            # Add finished IP address to list
            finalList.append(currIP[:-1])
            return
        
        # If more than 4 dots were used, exit function because currIP is an invalid address
        if numOfDots > 4:
            return
        
        # Make a recursive call
        maxLength = min(currIdx + 3, len(s)) # <= Used min() to stop from going out-of-bounds in loop
        for newIdx in range(currIdx, maxLength):
            
            # Get current number
            currNum = int(s[currIdx:newIdx + 1])
    
            # If currNum is a valid subnet, continue
            # NOTE: 2nd condition states, "only 1 digit can be passed or it cannot be a 0"
            if currNum <= 255 and (currIdx == newIdx or s[currIdx] != "0"):
                self.backTrack(s, newIdx + 1, numOfDots + 1, currIP + str(currNum) + ".", finalList)
    
    def restoreIpAddresses(self, s: str) -> List[str]:
        
        # If "s" is alphabetical or alphanum, exit function
        if s.isalpha():
            return []
        
        # If "s" is not at least 4 digits long or greater than 12 digits, exit function
        if len(s) < 4 or len(s) > 12:
            return []
        
        # Create a list
        finalList = list()
        self.backTrack(s, 0, 0, "", finalList)
        
        return finalList
            
        
