# https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution:
    def reverseVowels(self, s: str) -> str:
        
        # If s is none or only has a length of 1, return it
        if s is None or len(s) == 1:
            return s
        
        # Convert all letters to lowercase
        s = list(s)
        
        # Create 2 pointers
        leftPtr = 0
        rightPtr = len(s) - 1
        
        # Iterate string
        vowels = {"a", "A", "e", "E", "i", "I", "o", "O", "u", "U"}
        while leftPtr < rightPtr:
            
            # Check that both pointers are at vowels
            if s[leftPtr] in vowels and s[rightPtr] in vowels:
                
                # Swap letters
                oldLetter = s[leftPtr]
                s[leftPtr] = s[rightPtr]
                s[rightPtr] = oldLetter
                
                # Move pointers
                leftPtr += 1
                rightPtr -= 1
        
            # If rightPtr isn't at a vowel, move it
            elif s[leftPtr] in vowels and s[rightPtr] not in vowels:
                rightPtr -= 1
            
            # If leftPtr isn't at a vowel, move it
            elif s[leftPtr] not in vowels and s[rightPtr] in vowels:
                leftPtr += 1
            
            # If neither pointers are at a vowel, move pointers
            else:
                leftPtr += 1
                rightPtr -= 1
        
        # Convert list back to string
        return "".join(s)
