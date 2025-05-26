// https://leetcode.com/problems/summary-ranges/?envType=problem-list-v2&envId=array
// https://www.youtube.com/watch?v=ZHJDwbfqoa8

/*
Time Complexity: O(n) where n = length of nums. It's not n^2 because the inner while-loop isn't creating a new
    iterator and it's not rescanning elements.

Space Complexity: O(n) where n = length of nums. The worst case scenario is an input array with no range.
    E.g., [1, 3, 5, 7,...]
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();

        int numsLength = nums.length;
        int idx = 0;
        while (idx < numsLength) {
            int startingNum = nums[idx];

            while (idx < numsLength - 1 && nums[idx] + 1 == nums[idx + 1]) {
                idx++;
            }

            if (startingNum != nums[idx]) {
                String newEntry = String.format("%s->%s", startingNum, nums[idx]);
                res.add(newEntry);
            } else {
                res.add(String.valueOf(nums[idx]));
            }

            idx++;
        }

        return res;
    }
}
