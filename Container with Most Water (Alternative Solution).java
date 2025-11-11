// https://leetcode.com/problems/container-with-most-water/
/*
Time Complexity: O(n/2) where n = length of height. This is because we're using pointers that will eventually meet at the midpoint (best case scenario).
Space Complexity: O(1) because no dynamic data structure was created.
*/

class Solution {
    public int maxArea(int[] height) {
        int leftPtr = 0;
        int rightPtr = height.length - 1;

        int maxVolume = 0;
        while (leftPtr < rightPtr) {

            int leftWallHeight = height[leftPtr];
            int rightWallHeight = height[rightPtr];

            int curVolume = 0;
            if (leftWallHeight < rightWallHeight) {
                curVolume = (rightPtr - leftPtr) * leftWallHeight;
                maxVolume = Math.max(maxVolume, curVolume);

                leftPtr++;
            } else {
                curVolume = (rightPtr - leftPtr) * rightWallHeight;
                maxVolume = Math.max(maxVolume, curVolume);

                rightPtr--;
            }
        }

        return maxVolume;
    }
}
