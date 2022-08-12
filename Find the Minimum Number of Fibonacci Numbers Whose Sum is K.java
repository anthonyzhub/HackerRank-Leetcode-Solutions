// https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

class Solution {
    
    public ArrayList<Integer> generateFib(int k) {
        
        // OBJECTIVE: Return a list of fibonacci numbers from 1 to k
        
        // Create a list
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        
        // Populate list
        int num = 1;
        while (num < k) {
            
            // Get the last 2 numbers
            int numA = fib.get(fib.size() - 1);
            int numB = fib.get(fib.size() - 2);
            
            // If new number is less than or equal to k, update num and add it to list
            if (numA + numB <= k) {
                num = numA + numB;
                fib.add(num);
            }
            
            // If new number is greater than k, exit loop
            else {
                break;
            }
        }
        
        return fib;
    }
    
    public int findK(ArrayList<Integer> fib, int n, int target) {
        
        // OBJECTIVE: Return index of target or number closest to it
        
        // If target equals to 0, exit function
        if (target == 0) {return 0;}
        
        // If target is greater than or equal to fib's last element, return it
        if (target >= fib.get(n - 1)) {return n - 1;}
        
        // Create left and right pointers
        int leftPtr = 0;
        int rightPtr = n - 1;
        
        // Do binary search to find target in fib
        while (leftPtr < rightPtr) {
            
            // Create a middle pointer
            int midPtr = (int) (leftPtr + rightPtr) / 2;
            
            // If middle element is greater than target, move rightPtr
            if (fib.get(midPtr) > target) {
                rightPtr = midPtr;
            }
            
            // If middle element is less than or equal to target, move leftPtr
            else {
                leftPtr = midPtr + 1;
            }
        }
        
        // Return left pointer
        return leftPtr - 1;
    }
    
    public int findMinFibonacciNumbers(int k) {
        
        // OBJECTIVE: Return the minimum number of fibonacci numbers whose sum is equal to k
     
        // If k equals to 1, return it
        if (k == 1) {return 1;}
        
        // Generate a list of fibonacci numbers from 1 to k
        ArrayList<Integer> fib = generateFib(k);
        int n = fib.size();
        
        // If the last element equals to k, return 1
        if (fib.get(n - 1) == k) {return 1;}
        
        // Create a variable to hold minimum number of fibonacci numbers
        int minLen = 0;
        
        // Get minimum number of fibonacci numbers
        while (k > 0) {
            
            // Find k (or value closest to k) in fib
            int idx = findK(fib, n, k);
            
            // Increment minLen
            minLen++;
            
            // Update k by subtracting idx element from it
            k -= fib.get(idx);
        }
        
        return minLen;
    }
}
