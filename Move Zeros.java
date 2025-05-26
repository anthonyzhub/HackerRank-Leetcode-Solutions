// https://leetcode.com/problems/move-zeroes/?envType=problem-list-v2&envId=array

/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(n) where n = length of idxOfNonZeroElems.
*/

class Solution {

    private List<Integer> getIdxOfNonZeroElems(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res.add(Integer.valueOf(nums[i]));
            }
        }

        return res;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        List<Integer> idxOfNonZeroElems = getIdxOfNonZeroElems(nums);

        // Pop elements from list and maintain order.
        int idx = 0;
        while (idx < nums.length && !idxOfNonZeroElems.isEmpty()) {
            nums[idx] = idxOfNonZeroElems.remove(0);
            idx++;
        }

        // Continue to use previous iterator and populate rest of input list with 0s.
        for (; idx < nums.length; idx++) {
            nums[idx] = 0;
        }
    }
}
