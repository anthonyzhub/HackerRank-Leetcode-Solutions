# https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

class Solution:
    
    def generateFib(self, k):
        
        # OBJECTIVE: Return a list of fibonacci numbers from 1 to k
        
        # Create list
        fib = [1, 1]
        
        # Populate list
        num = 1
        while num < k:
            
            # If the new number is less than or equal to k, update num and add it to list
            if fib[-1] + fib[-2] <= k:
                num = fib[-1] + fib[-2]
                fib.append(num)
            
            # If the new number is greater than k, exit loop
            else:
                break
                
        return fib
    
    def findK(self, fib, n, target):
        
        # OBJECTIVE: Return index of element that equals or closest to target
        
        # If target is 0, exit function
        if target == 0:
            return 0
        
        # If target is greater than or equal to fib's last element, return it
        if target >= fib[n - 1]:
            return n - 1
        
        # Create left and right pointers
        leftPtr = 0
        rightPtr = n - 1
        
        # Do binary search to find target in fib
        while leftPtr < rightPtr:
            
            # Create middle pointer
            midPtr = (leftPtr + rightPtr) // 2
            
            # If middle element is greater than target, move rightPtr
            if fib[midPtr] > target:
                rightPtr = midPtr
            
            # If middle element is less than or equal to target, move leftPtr
            else:
                leftPtr = midPtr + 1
        
        # Return left pointer
        return leftPtr - 1
    
    def findMinFibonacciNumbers(self, k: int) -> int:
        
        # OBJECTIVE: Return the minimum number of fibonacci numbers whose sum is equal to k
        
        # If k equals to 1, return 1.
        # NOTE: Added this to avoid O(n) space and run time
        if k == 1:
            return 1
        
        # Generate a list of fibonacci numbers from 1 to k
        fib = self.generateFib(k)
        n = len(fib)
        
        # If last element equals to k, return 1
        if fib[-1] == k:
            return 1
        
        # Create a variable to hold minimum number of fibonacci numbers
        minLen = 0
        
        # Get minimum number of fibonacci numbers
        while k > 0:
            
            # Find k (or value closest to k) in fib
            idx = self.findK(fib, n, k)
            
            # Increment minLen
            minLen += 1
            
            # Update k by subtracting idx element from it
            k -= fib[idx]
            
        return minLen
