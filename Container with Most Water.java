// https://leetcode.com/problems/container-with-most-water/

/*
Time Complexity: O(n/2) where n = length of input array
Space Complexity: O(1) because no additional dynamic data structure was created
*/

class Solution {
    public int maxArea(int[] height) {
        
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }

        // Create 2 pointers
        int leftPtr = 0;
        int rightPtr = height.length - 1;

        // Iterate list until pointers meet
        int maxArea = 0;
        while (leftPtr < rightPtr) {

            // Calculate area between pointers
            int curDistance = rightPtr - leftPtr;
            int curArea = Math.min(height[leftPtr], height[rightPtr]) * curDistance;
            
            // Update max
            maxArea = Math.max(maxArea, curArea);

            // Only move pointer that is pointing to a lower number
            // IMPORTANT: Our goal is to find the max area, so it's best to find the next largest number
            if (height[leftPtr] < height[rightPtr]) {
                leftPtr++;
            }
            else {
                rightPtr--;
            }
        }

        return maxArea;
    }
}
