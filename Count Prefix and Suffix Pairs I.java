// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/
/*
Time Complexity: O(n^2) where n = length of words. A nested loop is used to check every i index against j index.
    Remember, every pair of [i, j] indices must be checked where i < j.

Space Complexity: O(1). No additional space was accquired.
*/

class Solution {

    private boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    public int countPrefixSuffixPairs(String[] words) {
        if (words.length <= 1) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    result++;
                }
            }
        }

        return result;
    }
}
