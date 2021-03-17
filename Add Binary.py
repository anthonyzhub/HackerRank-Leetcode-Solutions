# Link: https://leetcode.com/problems/add-binary/submissions/

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        
        # Turn strings to integers
        a = int(a,2)
        b = int(b,2)
        
        # Add integers
        binarySum = a + b
        
        # Turn integer to binary, then string and parse it:
        # E.g. '0b100' => '100'
        return str(bin(binarySum))[2:]
