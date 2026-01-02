// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(n) where n = size of map.
*/

class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            if (freqMap.get(nums[i]) == n) {
                return nums[i];
            }
        }

        // NOTE: Added above if-statement to save myself from another iteration
        // for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
        //     if (entry.getValue() == n) {
        //         return entry.getKey();
        //     }
        // }

        return 1;
    }
}
