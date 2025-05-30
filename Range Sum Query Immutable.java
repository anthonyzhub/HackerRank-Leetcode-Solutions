// https://leetcode.com/problems/range-sum-query-immutable
/*
Time Complexity: O(right - left) because the loop only runs within the given range.

Space Complexity: O(n) where n = length of nums.
*/
class NumArray {

    int[] nums = null;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (left == right) {
            return nums[left];
        }

        int sum = 0;
        for (int i = left; i < right + 1; i++) {
            sum += nums[i];
        }

        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
