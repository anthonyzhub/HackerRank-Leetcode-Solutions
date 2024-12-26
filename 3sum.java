// https://leetcode.com/problems/3sum/
// https://youtu.be/jzZsG8n2R9A?si=6wwyIbXWD-jahVbE

/*
Time Complexity: O(n log n + (n^2)) where n = length of nums
Space Complexity: O(m) where m = size of res
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();

        for (int idx = 0; idx < nums.length; idx++) {

            // If this isn't the first iteration and there are repeating numbers, skip to next element
            if (idx > 0 && nums[idx - 1] == nums[idx]) {
                continue;
            }

            // Create 2 pointers and traverse remaining half of array
            int leftPtr = idx + 1;
            int rightPtr = nums.length - 1;
            while (leftPtr < rightPtr) {
                int threeSum = nums[idx] + nums[leftPtr] + nums[rightPtr];

                // Adjust pointer if current total isn't equal to 0.
                // If it is, add combination to return array
                if (threeSum > 0) {
                    rightPtr--;
                }
                else if (threeSum < 0) {
                    leftPtr++;
                }
                else {
                    List<Integer> possibleSolution = new ArrayList<>(Arrays.asList(nums[idx], nums[leftPtr], nums[rightPtr]));
                    res.add(possibleSolution);
                    leftPtr++;

                    // We need to move a pointer (it could be any) to a new number
                    // IMPORTANT: Neetcode explains best at minute 10
                    while (leftPtr < rightPtr && nums[leftPtr - 1] == nums[leftPtr]) {
                        leftPtr++;
                    }
                }
            }
        }

        return res;
    }
}
