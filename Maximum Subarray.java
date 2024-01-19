// https://leetcode.com/problems/maximum-subarray/
// https://www.youtube.com/watch?v=5WZl3MMT0Eg

class Solution {

    public int maxSubArray(int[] nums) {

        /*
         * Time Complexity: O(n) where n = length of nums. A for-loop is created to iterate array once
         * Space Complexity: O(1) because no dynamic data structures were created
         */

        // Set as first element as maxSum. 
        // NOTE: Function is guaranteed to have an input array with at least 1 element
        int maxSum = nums[0];

        if (nums.length == 1) {
            return maxSum;
        }

        // Iterate array and calculate possible maxSum
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {

            // If a negative number previously wiped out curSum, reset it
            // IMPORTANT: We start counting on positive elements only
            if (curSum < 0) {
                curSum = 0;
            }

            // Update curSum with ith element and recalculate maximum subarray
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}