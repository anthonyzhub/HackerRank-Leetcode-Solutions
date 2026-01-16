/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
https://youtu.be/nIVW4P8b1VA?si=vHyWawiiCKtWzlvs

Time Complexity: O(log n) where n = length of nums. Binary search is performed in this algorithm

Space Complexity: O(1)
*/
class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;

        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        while (leftPtr <= rightPtr) {

            // If array is already sorted, then exit loop
            if (nums[leftPtr] < nums[rightPtr]) {
                res = Math.min(res, nums[leftPtr]);
                break;
            }

            int midPtr = leftPtr + ((rightPtr - leftPtr) / 2);
            res = Math.min(res, nums[midPtr]);

            // If nums[midPtr] >= nums[leftPtr], search right-half of array. Vice versa.
            if (nums[midPtr] >= nums[leftPtr]) {
                leftPtr = midPtr + 1;
            } else {
                rightPtr = midPtr - 1;
            }
        }

        return res;
    }
}
