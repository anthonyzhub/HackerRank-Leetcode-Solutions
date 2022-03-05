// https://leetcode.com/problems/count-primes/

class Solution {
    
    public int countPrimes(int n) {
        
        // IMPORTANT: A prime number must be greater than 1 and is only divisible by 1 and itself.
        // Method is called "Sieve of Eratosthenes"
        
        // Create a boolean array
        boolean[] isNumPrime = new boolean[n];
        Arrays.fill(isNumPrime, true);
        
        // Traverse to halfway point of n
        // NOTE: First products of sqrt(n) is the same as the products from sqrt(n) to n
        for (int i=2; i*i<n; i++) {
            
            // Check if element at ith position is a prime number
            if (isNumPrime[i]) {
                
                // Define every multiple of i into a non-prime number
                for (int j=i*i; j<n; j+=i) {
                    isNumPrime[j] = false;
                }
            }
        }
        
        // Count how many prime numbers there are left
        int counter = 0;
        for (int i=2; i<n; i++) {
            if (isNumPrime[i]) {counter++;}
        }
        
        return counter;
    }
}
