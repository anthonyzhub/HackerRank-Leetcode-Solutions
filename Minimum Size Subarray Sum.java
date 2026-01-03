// https://leetcode.com/problems/minimum-size-subarray-sum/
/*
Time Complexity: O(n) where n = length of nums

Space Complexity: O(1) because no additional dynamic memory was allocated
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }

        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;

        // Iterate array
        int leftPtr = 0;
        for (int rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            
            // If curNum == target, then return 1. Can't find smaller window than that.
            int curNum = nums[rightPtr];
            if (curNum == target) {
                return 1;
            }

            windowSum += curNum;

            // Shrink window until a smaller window isn't possible
            while (windowSum >= target) {

                minLen = Math.min(minLen, (rightPtr - leftPtr) + 1);

                // Shrink window and update windowSum
                windowSum -= nums[leftPtr];
                leftPtr++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
