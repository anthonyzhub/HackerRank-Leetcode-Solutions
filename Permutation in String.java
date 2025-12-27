// https://leetcode.com/problems/permutation-in-string/
/*
Time Complexity: O(n) where n = length of the longest string

Space Complexity: O(1) because the new arrays will always take constant size, which is 26.
    26 comes from how many letters there are in the alphabet.
*/

class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Create an array that will hold the frequency of each letter per string
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Calculate how many matches there already are
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        // Create a sliding window and iterate both strings
        // NOTE: At this point, it assumes s1 is shorter than s2
        int leftPtr = 0;
        for (int rightPtr = s1.length(); rightPtr < s2.length(); rightPtr++) {
            if (matches == 26) {
                return true;
            }

            // Update s2Count from rightPtr
            int charAtRightPtr = s2.charAt(rightPtr) - 'a';
            s2Count[charAtRightPtr]++;

            // Check if there are more matches or not after s2Count update
            if (s1Count[charAtRightPtr] == s2Count[charAtRightPtr]) {
                matches++;
            } else if (s1Count[charAtRightPtr] + 1 == s2Count[charAtRightPtr]) {
                matches--;
            }

            // Update s2Count from leftPtr
            int charAtLeftPtr = s2.charAt(leftPtr) - 'a';
            s2Count[charAtLeftPtr]--; // <= If we're moving the leftPtr, that means there is 1 less letter in the sliding window

            // Check if there are more matches or not after s2Count update
            if (s1Count[charAtLeftPtr] == s2Count[charAtLeftPtr]) {
                matches++;
            } else if (s1Count[charAtLeftPtr] - 1 == s2Count[charAtLeftPtr]) {
                matches--;
            }

            leftPtr++;
        }

        return matches == 26;
    }
}
