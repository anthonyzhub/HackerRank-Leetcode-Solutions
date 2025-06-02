// https://leetcode.com/problems/rotate-array
// https://www.youtube.com/watch?v=BHr381Guz3Y
/*
Time Complexity: O(n) where n = length of nums. The 1st part of the solution involves reversing the entire array.

Space Complexity: O(1) because no additional space was allocated.
*/

class Solution {

    private void reverseArray(int[] nums, int leftIdx, int rightIdx) {
        while (leftIdx < rightIdx) {
            int prevNumber = nums[leftIdx];
            nums[leftIdx] = nums[rightIdx];
            nums[rightIdx] = prevNumber;

            leftIdx++;
            rightIdx--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        // Reverse entire array
        reverseArray(nums, 0, nums.length - 1);
        
        // Reverse 1st half of array and then 2nd
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }
}
