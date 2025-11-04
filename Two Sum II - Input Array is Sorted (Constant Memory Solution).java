// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
/*
Time Complexity: O(n) where n = length of input array.

Space Complexity: O(1) because no dynamic data structure was created.
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[]{1, 2};
        }

        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (leftPtr < rightPtr) {
            int curSum = numbers[leftPtr] + numbers[rightPtr];

            if (curSum == target) {
                return new int[]{leftPtr + 1, rightPtr + 1};
            } else if (curSum > target) {
                rightPtr--;
            } else {
                leftPtr++;
            }
        }

        return new int[]{};
    }
}
