# https://leetcode.com/problems/nth-digit
# Reference: https://leetcode.com/problems/nth-digit/discuss/2419607/Python-or-Binary-Search-or-O(logn)

class Solution:
    
    def helper(self, num):
        
        # Get length of num
        numOfDigits = len(str(num))
        
        # Iterate range
        count = 0
        for i in range(numOfDigits - 1):
            
            count += 9 * pow(10, i) * (i + 1)
            
        return count + (num - pow(10, numOfDigits - 1) + 1) * numOfDigits
    
    def findNthDigit(self, n: int) -> int:
        
        # If n is less than 10, return itself
        if n < 10:
            return n
        
        # Create 2 pointers
        leftPtr = 1
        rightPtr = n
        
        # Iterate sequence
        while leftPtr < rightPtr:
            
            # Calculate midPtr
            midPtr = (leftPtr + rightPtr) // 2
            
            # If count is greater than or equal to n, minimize sequence from rightPtr
            if self.helper(midPtr) >= n:
                rightPtr = midPtr
            
            # If count is less than n, minimize sequence from leftPtr
            else:
                leftPtr = midPtr + 1
        
        # Convert leftPtr to string in reverse order and then get nth element
        ans = str(leftPtr)[::-1]
        ans = ans[self.helper(leftPtr) - n]
        
        return int(ans)
