// https://leetcode.com/problems/contains-duplicate-ii/
// Reference: https://youtu.be/ypn0aZ0nrL4?si=GgHTsIcDyngwCsMW

/*
Time Complexity: O(n) where n = length of nums
Space Complexity: O(k) where k is the input parameter that affects the size of the sliding window
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }

        // Create a set that will act as a sliding window
        Set<Integer> slidingWindow = new HashSet<>();
        int leftPtr = 0;

        // Iterate nums
        for (int rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            
            // If window is bigger than k, then drop first element
            // NOTE: First element was most likely already checked if this isn't the first iteration.
            boolean isWindowTooBig = (rightPtr - leftPtr) > k;
            if (isWindowTooBig) {
                slidingWindow.remove(nums[leftPtr]);
                leftPtr++;
            }

            // If current element already exist in sliding window, then a duplicate was found
            if (slidingWindow.contains(nums[rightPtr])) {
                return true;
            }

            // Add new number to sliding window
            slidingWindow.add(nums[rightPtr]);
        }

        return false;
    }
}
