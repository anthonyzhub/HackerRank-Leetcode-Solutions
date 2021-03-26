# Link: https://leetcode.com/problems/bulls-and-cows/submissions/

"""
Bull (A)- Correct digit at correct place
Cow (B) - Correct digit at incorrect place
"""

class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        
        # If secret and guess match, return string
        if secret == guess:
            return "{}A0B".format(len(secret))
        
        # Turn both strings to lists
        secretList = list(secret)
        guessList = list(guess)
        
        # Create counters
        aCounter = 0
        bCounter = 0
        
        # Iterate string to look for matching positions
        for i in range(len(secret)):
            
            # Look for matching pair
            if secret[i] == guess[i]:
                
                # Increment counter
                aCounter += 1
                
                # Remove element from both lists
                secretList.remove(secret[i])
                guessList.remove(guess[i])
        
        # Rename lists based on size
        if len(secretList) >= len(guessList):
            maxList = secretList
            minList = guessList
        else:
            maxList = guessList
            minList = secretList
        
        # Iterate both lists
        for i in range(len(minList)):
            for j in range(len(maxList)):
                
                # If an identical number is found, pop element from maxList
                if minList[i] == maxList[j]:
                    bCounter += 1
                    maxList.pop(j)
                    break # <= Exit inner loop to update i
                    
            if len(maxList) == 0: # <= In case both list have equal length
                break
            
        # Return string
        return "{}A{}B".format(aCounter, bCounter)
