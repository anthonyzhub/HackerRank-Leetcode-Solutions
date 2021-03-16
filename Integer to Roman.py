# Link: https://leetcode.com/problems/integer-to-roman/submissions/

class Solution:
    def intToRoman(self, num: int) -> str:
        
        # Create a dictionary of numeric values to roman numerals
        numToRomDict = {1000: "M",
                        900: "CM",
                        500: "D",
                        400: "CD",
                        100: "C",
                        90: "XC",
                        50: "L",
                        40: "XL",
                        10: "X",
                        9: "IX",
                        5: "V",
                        4: "IV",
                        1: "I"}
        
        # Check if num is already in dictionary
        if num in numToRomDict.keys():
            return numToRomDict[num]
        
        ans = ""
        
        # Iterate dictionary
        for k,v in numToRomDict.items():

            # Continue until num is either 0 or less than
            while num > 0:
                
                # If K is bigger, then subtract num and update string
                if num >= k:
                    num -= k
                    ans += v
                else:
                    break # Exit while-loop and move to next key
            
        return ans
