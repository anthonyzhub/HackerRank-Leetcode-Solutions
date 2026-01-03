// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://youtu.be/wiGpQwVHdE0?si=JAWf10zkRJdz1v2p
/*
Time Complexity: O(n) where n = length of input string

Space Complexity: O(n) where n = length of set
Thought Process
- Create a set to keep track of elements in window
- Create a left and right pointer
- For every new and unique character in window, we add element to set and make the window bigger
- If we find a non-unique character, we need to make the window smaller:
    - First, we pop any elements from the left side to make the window smaller
    - Second, if we pop the non-unique element, we continue iterating the string
- Every time we move the right pointer, we calculate the substring length and update max length
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        // Create a set
        Set<Character> windowElems = new HashSet<>();

        // Iterate string
        int leftPtr = 0;
        int maxLen = 0;
        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            Character curLetter = s.charAt(rightPtr);

            // If curLetter exist in window, pop the leftmost letter until curLetter doesn't exist
            // This helps to make the window smaller until only unique elements exist in window
            while (windowElems.contains(curLetter)) {
                Character farLeftLetter = s.charAt(leftPtr);
                windowElems.remove(farLeftLetter);
                leftPtr++;
            }

            // Add new letter to window tracker and update maxLen
            windowElems.add(curLetter);

            // +1 because it starts counting at 0
            maxLen = Math.max(maxLen, (rightPtr - leftPtr) + 1);
        }

        return maxLen;
    }
}
