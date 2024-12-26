// https://leetcode.com/problems/valid-palindrome/

/*
Time Complexity: O(n) where n = length of input string.
Space Complexity: O(1) because no additional dynamic data structure was created.
*/

class Solution {

    private String removeNonAlphaNumericCharacters(String inputStr) {
        return inputStr.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private boolean traverseStringBothWays(String inputStr) {
        int leftPtr = 0;
        int rightPtr = inputStr.length() - 1;

        while (leftPtr < rightPtr) {

            if (inputStr.charAt(leftPtr) != inputStr.charAt(rightPtr)) {
                return false;
            }

            leftPtr++;
            rightPtr--;
        }

        return true;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        String strippedStr = removeNonAlphaNumericCharacters(s);
        return traverseStringBothWays(strippedStr);
    }
}
