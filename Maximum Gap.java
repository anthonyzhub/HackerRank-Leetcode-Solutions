// https://leetcode.com/problems/maximum-gap
/*
Time Complexity: O(n log n) where n = length of nums. Most of the time is spent sorting the array.

Space Complexity: O(1) because no additional 
*/
class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            
            int curGap = nums[i] - nums[i-1]; 
            if (curGap > maxGap) {
                maxGap = curGap;
            }
        }

        return maxGap;
    }
}
