// https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        
        /*
        OBJECTIVE: Return the maximum amount of water a container can store.
        
        Time Complexity: O(n) where n = length of height. The list is iterated once with 2 pointers. By using two pointers in one loop, it helps inspect 
                        the list quickly.
        
        Space Complexity: O(1) because no additional space was used
        */

        // Get array's length
        int n = height.length;

        // Create 2 pointers and calculate current width
        int leftPtr = 0;
        int rightPtr = n - 1;
        int width = rightPtr - leftPtr;

        // Create a variable to hold maximum area between left and right pointer
        // NOTE: Formula for area of a rectangle is width * height and the minimum height is calculated because it is the maximum amount of water that 
        //        will hold. E.g., If there are 2 walls with a height of 1 and 8. Between those 2 walls, the water will spill after surpassing the wall
        //        with the height of 1.
        int res = width * Math.min(height[leftPtr], height[rightPtr]);

        // Iterate array
        while (leftPtr < rightPtr) {

            // If left value is smaller than right, move left pointer
            if (height[leftPtr] < height[rightPtr]) {
                leftPtr++;
            }
            else {
                rightPtr--;
            }

            // Update width after every pointer movement
            width = rightPtr - leftPtr;

            // Keep maximum rectangle area
            res = Math.max(res, width * Math.min(height[leftPtr], height[rightPtr]));
        }

        return res;
    }
}
