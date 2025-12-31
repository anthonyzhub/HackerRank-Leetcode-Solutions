// https://leetcode.com/problems/move-zeroes/
/*
My thought process: 
Input: [0, 1, 0, 3, 12]
 
 l r
[0, 1, 0, 3, 12]

   l.  r
[1, 0, 0, 3, 12]

   l.     r
[1, 0, 0, 3, 12]

       l     r
[1, 3, 0, 0, 12]

- create 2 pointers, left and right
- left pointer will point to the last 0-element
- right pointer will move in for-loop
- if right finds a non-zero, swap with left pointer and set right-index to 0. Increment left pointer

Time Complexity: O(n) where n = size of nums.

Space Complexity: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {
        
        // Have leftPtr point to the very 1st index that has a 0
        int leftPtr = 0;
        while (leftPtr < nums.length && nums[leftPtr] != 0) {
            leftPtr++;
        }

        // If leftPtr is at the end of the array, then array doesn't have a 0
        if (leftPtr == nums.length) {
            return;
        }
        
        // Iterate array from leftPtr + 1 to the end
        for (int rightPtr = leftPtr + 1; rightPtr < nums.length; rightPtr++) {

            // If element is a 0, then swap values and move leftPtr
            if (nums[rightPtr] != 0) {
                nums[leftPtr] = nums[rightPtr];
                nums[rightPtr] = 0;
                leftPtr++;
            }
        }
    }
}
