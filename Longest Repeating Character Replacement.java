// https://leetcode.com/problems/longest-repeating-character-replacement/
/*
Time Complexity: O(n) where n = length of s string

Space Complexity: O(n) where n = # of unique characters inside input string
*/

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int result = 0;

        int leftPtr = 0;
        int maxFreq = 0;
        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            Character rightPtrLetter = Character.valueOf(s.charAt(rightPtr));
            charFreq.put(rightPtrLetter, charFreq.getOrDefault(rightPtrLetter, 0) + 1);
            maxFreq = Math.max(maxFreq, charFreq.get(rightPtrLetter));

            // Window Length - Max Frequency > k
            // IMPORTANT: It's best not to assign (rightPtr - leftPtr + 1) to a variable
            //  because the leftPtr is constantly updating in this loop.
            while ((rightPtr - leftPtr + 1) - maxFreq > k) {
                Character leftPtrLetter = Character.valueOf(s.charAt(leftPtr));
                charFreq.put(leftPtrLetter, charFreq.get(leftPtrLetter) - 1);
                leftPtr++;
            }

            result = Math.max(result, rightPtr - leftPtr + 1);
        }

        return result;
    }
}
