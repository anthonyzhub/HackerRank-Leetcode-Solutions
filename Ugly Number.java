// https://leetcode.com/problems/ugly-number/

class Solution {
    public boolean isUgly(int n) {
        
        // If n is less than 0, return false
        if (n < 0) {return false;}
        
        // Continue to divide number until condition is false
        while (n > 1) {
            
            if (n % 2 == 0) {
                n /= 2;
            }
            else if (n % 3 == 0) {
                n /= 3;
            }
            else if (n % 5 == 0) {
                n /= 5;
            }
            else {
                return false;
            }
        }
        
        // If n equals to 1, then n is an ugly number
        if (n == 1) {return true;}
        return false;
    }
}
