# https://leetcode.com/problems/repeated-dna-sequences/

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        # If string has less than 10 characters, exit function
        if len(s) < 10:
            return
        
        # Create a dictionary
        sequenceLog = dict()
        
        # Cycle string
        for i in range(0, len(s)):
            
            # Create substring
            subStr = s[i:i+10]
            
            # If key already exist, update value. If not, add it to dictionary
            if subStr in sequenceLog.keys():
                sequenceLog[subStr] += 1
            else:
                sequenceLog[subStr] = 1
                
        # Cycle dictionary
        ans = list()
        for k, v in sequenceLog.items():
            
            # If substring occurred more than once in s, add it to ans
            if v > 1:
                ans.append(k)
                
        return ans
