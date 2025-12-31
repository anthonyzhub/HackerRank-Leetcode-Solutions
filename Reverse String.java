// https://leetcode.com/problems/reverse-string/
/*
Time Complexity: O(n/2) where n = length of s.

Space Complexity: O(1)
*/

class Solution {
    public void reverseString(char[] s) {

        // If array has length of 1, then exit function. Nothing can be swapped
        if (s.length <= 1) {
            return;
        }

        // Create a left and right pointer
        int leftPtr = 0;
        int rightPtr = s.length - 1;

        // Swap elements and move pointers
        while (leftPtr < rightPtr) {
            char holder = s[leftPtr];
            s[leftPtr] = s[rightPtr];
            s[rightPtr] = holder;

            leftPtr++;
            rightPtr--;
        }
    }
}
