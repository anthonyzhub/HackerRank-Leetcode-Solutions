// https://leetcode.com/problems/trapping-rain-water/

/*
Time Complexity: O(n) where n = length of input array.
Space Complexity: O(n) where n = length of input array. 2 additional arrays were created with N size.
*/

class Solution {

    private int[] getMaximumNumberFromLeftSide(int[] height) {
        int[] maxLeft = new int[height.length];

        for (int i = 0; i < height.length; i++) {

            // Set max height to 0 because water can't be held at the end of an array
            if (i == 0) {
                maxLeft[i] = 0;
                continue;
            }
            // After the 1st iteration, compare height from input array instead of the new array.
            // Or else, you will be skipping a number.
            else if (i == 1) {
                maxLeft[i] = Math.max(height[i - 1], height[i]);
                continue;
            }

            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        return maxLeft;
    }

    private int[] getMaximumNumberFromRightSide(int[] height) {
        int[] maxRight = new int[height.length];

        for (int i = height.length - 1; i > 0; i--) {

            // Set max height to 0 because water can't be held at the end of an array
            if (i == height.length - 1) {
                maxRight[i] = 0;
                continue;
            }
            // After the 1st iteration, compare height from input array instead of the new array.
            // Or else, you will be skipping a number.
            else if (i == height.length - 2) {
                maxRight[i] = Math.max(height[i + 1], height[i]);
                continue;
            }

            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        return maxRight;
    }

    private int calculateTrappedWater(int[] height, int[] leftMax, int[] rightMax) {
        int totalWaterTrapped = 0;

        for (int i = 0; i < height.length; i++) {

            // Get the smallest height from both list and check how much water is trapped at current position
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            int curWaterTrapped = minHeight - height[i];
            
            // You can't add water if there's no place. Therefore, skip negative numbers.
            if (curWaterTrapped > 0) {
                totalWaterTrapped += curWaterTrapped;
            }
        }

        return totalWaterTrapped;
    }

    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }

        // Create an array where it inserts the largest number from one side
        // E.g., from left to right, insert the largest number from 0 to ith index to new array.
        //      Continue to do this until you reach the end of the input array. Repeat for other side.
        int[] maxNumbersFromLeftSide = getMaximumNumberFromLeftSide(height);
        int[] maxNumbersFromRightSide = getMaximumNumberFromRightSide(height);
        
        return calculateTrappedWater(height, maxNumbersFromLeftSide, maxNumbersFromRightSide);
    }
}
