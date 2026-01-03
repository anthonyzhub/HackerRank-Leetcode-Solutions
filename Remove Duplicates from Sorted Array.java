// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// https://youtu.be/DEJAZBq0FDA?si=1TR4bryklCx_JKwV
/*
Time Complexity: O(n) where n = length of nums.

Space Complexity: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {

        // Return array's length if it has 0 or 1 elements
        if (nums.length <= 1) {
            return nums.length;
        }

        // Create a left pointer
        // IMPORTANT: I set leftRight = rightPtr because the very 1st element in nums will always be unique
        int leftPtr = 1;
        for (int rightPtr = leftPtr; rightPtr < nums.length; rightPtr++) {
            
            // If the last 2 elements are the same, skip to next iteration
            if (nums[rightPtr] == nums[rightPtr - 1]) {
                continue;
            }

            // If the last 2 elements are different, move new element to leftPtr and update leftPtr
            nums[leftPtr] = nums[rightPtr];
            leftPtr++;
        }

        // The first leftPtr elements are unique
        return leftPtr;
    }
}
