# https://leetcode.com/problems/count-primes/

class Solution:
    def countPrimes(self, n: int) -> int:
        
        # NOTE: Method is called "Sieve of Eratosthenes"
        
        # Create a list
        isNumPrime = [True] * n
        
        # Walk through numeric system until sqrt(n)
        # NOTE: The products from 1 to sqrt(n) are the same as sqrt(n) to n
        #       A while-loop was choosen because of condition for i
        i = 2
        while i*i < n:
            
            # Check if element at ith position is a prime number
            if isNumPrime[i]:
                
                # Define every multiple of i as a non-prime number
                j = i*i
                while j < n:
                    isNumPrime[j] = False
                    j += i
                  
            # Increment i
            i += 1
                    
        # Traverse list and count how many prime numbers are left
        counter = 0
        for i in range(2, len(isNumPrime)):
            if isNumPrime[i]:
                counter += 1
                
        return counter
