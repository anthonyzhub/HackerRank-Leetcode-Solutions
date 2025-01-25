// https://leetcode.com/problems/binary-search/
/*
Time Complexity: O(n log n) where n = size of nums. It could have been O(log n) if I didn't have to sort the array.
Space Complexity: O(n log n) where n = size of nums. It could have been O(log n) if I didn't have to sort the array.
*/

class Solution {

    private int find(int[] nums, int leftPtr, int rightPtr, int target) {
        if (leftPtr > rightPtr) {
            return -1;
        }

        int midPtr = leftPtr + ((rightPtr - leftPtr) / 2);

        if (target === nums[midPtr]) {
            return midPtr;
        }
        else if (target < nums[midPtr]) {
            return find(nums, leftPtr, midPtr - 1, target);
        }
        else {
            return find(nums, midPtr + 1, rightPtr, target);
        }
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // IMPORTANT: Binary search ONLY works if array is sorted
        Arrays.sort(nums);
        return find(nums, 0, nums.length - 1, target);
    }
}
