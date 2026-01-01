// https://leetcode.com/problems/majority-element/
/*
Time Complexity: O(n) where n = length of input array.

Space Complexity: O(n) where n = unique numbers in nums array.
*/

class Solution {
    public int majorityElement(int[] nums) {

        // If array is only has 1 number, return it.
        if (nums.length <= 1) {
            return nums[0];
        }

        // Populate map where key = number, value = number's frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            freqMap.put(curNum, freqMap.getOrDefault(curNum, 0) + 1);
        }

        // Iterate map to find key with value > goal
        // NOTE: Problem statement says there is a guaranteed answer, so last return statement won't execute.
        int goal = (int) nums.length / 2;
        for (Map.Entry<Integer, Integer> curEntry: freqMap.entrySet()) {
            if (curEntry.getValue() > goal) {
                return curEntry.getKey();
            }
        }

        return 1;
    }
}
