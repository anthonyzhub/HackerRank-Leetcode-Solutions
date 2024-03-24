// https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {

        /*
         * Time Complexity: O(n) where n = length of string. While-loop is iterating 
         *  string until the halfway point is reached. Keep in mind, in time and space complexity
         *  coefficients are dropped. So, O(n) equals to O(n/2).
         * 
         * Space Complexity: O(1) because no additional, dynamic data structure
         *  was created.
         */
        
        // Remove all non-alphanumeric characters and them uncapitalize all letters
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // If s has 1 or less characters, then it's automatically a palindrone
        if (s.length() <= 1) {
            return true;
        }

        // Create a left and right pointer
        int leftPtr = 0;
        int rightPtr = s.length() - 1;

        // Iterate string
        while (leftPtr <= rightPtr) {

            // If both characters don't equal each other, return false.
            // This string isn't a palindrone
            if (s.charAt(leftPtr) != s.charAt(rightPtr)) {
                return false;
            }

            // Move both pointers closer to the middle of the string
            leftPtr += 1;
            rightPtr -= 1;
        }

        // If function is still continuing, return true.
        // This string is a palindrone.
        return true;
    }
}