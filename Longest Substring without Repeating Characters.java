// https://leetcode.com/problems/longest-substring-without-repeating-characters/
/*
Time Complexity: O(n) where n = length of input string

Space Complexity: O(n) where n = length of set
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        // IMPORTANT: leftPtr and rightPtr will serve as the sliding window size
        Set<Character> charSet = new HashSet<>();
        int leftPtr = 0;
        int maxLength = 0;

        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            Character curChar = Character.valueOf(s.charAt(rightPtr));
            
            // Bc we're using a sliding window, we need to pop elements from window and set until condition isn't met
            while (charSet.contains(curChar)) {
                Character farLeftChar = Character.valueOf(s.charAt(leftPtr));
                charSet.remove(farLeftChar);
                leftPtr++;
            }

            charSet.add(curChar);
            maxLength = Math.max(maxLength, (rightPtr - leftPtr) + 1); // "+1" because it starts counting at 0.
        }

        return maxLength;
    }
}
