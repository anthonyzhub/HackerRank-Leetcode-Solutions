# Link: https://leetcode.com/problems/sentence-screen-fitting/submissions/

class Solution:
    def wordsTyping(self, sentence: List[str], rows: int, cols: int) -> int:
        
        # If string is empty, exit function
        if sentence == None or len(sentence) == 0:
            return 0
        
        # If either rows or cols 0, exit function
        if rows <= 0 or cols <= 0:
            return 0
        
        # Turn list into string
        sentence = " ".join(i for i in sentence) + " " # <= End string with a whitespace
        
        # Get length of string
        size = len(sentence)
        totalLen = 0
        
        # Iterate range
        for _ in range(rows):
            
            totalLen += cols
            
            if sentence[totalLen % size] == " ":
                totalLen += 1
            else:
                while sentence[(totalLen - 1) % size] != " " and totalLen > 0:
                    totalLen -= 1
                    
        return totalLen // size
