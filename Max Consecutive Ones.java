// https://leetcode.com/problems/max-consecutive-ones
/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(1) because no dynamic data structure was created.
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxLength = 0;
        int curLen = 0;

        for (int num: nums) {
            if (num == 1) {
                curLen++;
            } else {
                maxLength = Math.max(maxLength, curLen);
                curLen = 0;
            }
        }

        maxLength = Math.max(maxLength, curLen);

        return maxLength;
    }
}
