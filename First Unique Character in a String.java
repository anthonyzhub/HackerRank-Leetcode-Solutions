// https://leetcode.com/problems/first-unique-character-in-a-string/
/*
Time Complexity: O(n*2) where n = length of s. indexOf() and lastIndexOf() also takes O(n) time.

Space Complexity: O(n) where n = length of char array
*/

class Solution {
    public int firstUniqChar(String s) {
        // Iterate string as array
        for (char letter: s.toCharArray()) {

            // Get first and last occurrence of given letter
            int firstIdx = s.indexOf(letter);
            int lastIdx = s.lastIndexOf(letter);

            // If both are the same, then this is the first, non-duplicate character
            if (firstIdx == lastIdx) {
                return firstIdx;
            }
        }

        return -1;
    }
}
