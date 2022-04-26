/*
* https://leetcode.com/problems/valid-palindrome-ii/
* 
* Time complexity: O(n + 2(n - 1)) = O(n + 2n - 2) = O(2n + n) = O(n)
* Space complexity: O(1)
*/

class Solution {
    
    public boolean isPalindrome(String s, int frontPtr, int backPtr) {
         
        // OBJECTIVE: Check if substring is a palindrome
        
        // Traverse string
        while (frontPtr < backPtr) {
            
            // If both letters match, skip to next iteration
            if (s.charAt(frontPtr) == s.charAt(backPtr)) {
                frontPtr++;
                backPtr--;
                continue;
            }
            return false;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        
        // If length of s is 1, then it is a palindrome
        if (s.length() == 1) {return true;}
        
        // Create 2 pointers
        int frontPtr = 0;
        int backPtr = s.length() - 1;
        
        // Traverse string
        while (frontPtr < backPtr) {
            
            // If both letters match, skip to next iteration
            if (s.charAt(frontPtr) == s.charAt(backPtr)) {
                frontPtr++;
                backPtr--;
                continue;
            }
            
            // Compare left and right substring
            boolean leftStr = isPalindrome(s, frontPtr + 1, backPtr);
            boolean rightStr = isPalindrome(s, frontPtr, backPtr - 1);
            
            return leftStr || rightStr;
        }
        return true;
    }
}
