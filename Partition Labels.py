# Link: https://leetcode.com/problems/partition-labels/submissions/
# Credit/helpful video: https://www.youtube.com/watch?v=ED4ateJu86I

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
        # Create a list to hold each partition
        subStringsLen = list()
        
        # Add last index of letter to dictionary
        lastPosition = dict()
        for pos, i in enumerate(S):
            
            # If key exists, update value
            # If key doesn't exist, add value
            lastPosition[ord(i) - ord('a')] = pos
            
        # Iterate string
        it = 0
        while it < len(S):
            
            # Get last position of current character
            endIT = lastPosition[ord(S[it]) - ord('a')]
            
            # Create iterator for current position
            currIT = it
            
            # Execute loop until both iterators meet
            while currIT != endIT:
                
                # Update endIT if another internal character appears after current endIT
                endIT = max(endIT,  lastPosition[ord(S[currIT]) - ord('a')])
                currIT += 1 # Move iterator forward
                
            # Once currIT and endIT are at the same posiiton, save length of current substring
            # Get difference from starting point to ending point. Add 1 because counting starts at 0.
            subStringsLen.append(currIT - it + 1)
            it = currIT + 1 # Update position
            
        return subStringsLen
