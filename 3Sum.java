// https://leetcode.com/problems/3sum/
// https://youtu.be/jzZsG8n2R9A?si=6wwyIbXWD-jahVbE

/*
Time Complexity: O(n log n + (n^2)) where n = length of nums
Space Complexity: O(m) where m = size of res
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {

            // Skip duplicate numbers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Below is the 2Sum solution with 2 pointers and a slight modification
            int baseValue = nums[i];
            int leftPtr = i + 1;
            int rightPtr = numsLength - 1;
            while (leftPtr < rightPtr) {
                int curSum = baseValue + nums[leftPtr] + nums[rightPtr];

                if (curSum > 0) {
                    rightPtr--;
                } else if (curSum < 0) {
                    leftPtr++;
                } else {
                    result.add(List.of(baseValue, nums[leftPtr], nums[rightPtr]));

                    /* Breakdown:
                    This problem involves knowing combination and permutation. Let me explain.

                    The result must not contain duplicate numbers, however we can use the same base along side other numbers.
                    Below this comment, I'm keeping the baseValue but I'm moving the leftPtr to a brand new number. 
                    rightPtr will still be updated, but only if curSum > 0. I tested it and can confirm I can also only just update the rightPtr below.
                    By updating the leftPtr (or any pointer), I am simply creating a new combination and testing if its sum is equal to 0.

                    It took a while for me to realize why the below while-loop is important until I started to explain the code out loud. 
                    */
                    leftPtr++;
                    while (nums[leftPtr] == nums[leftPtr - 1] && leftPtr < rightPtr) {
                        leftPtr++;
                    }
                }
            }
        }

        return result;
    }
}
