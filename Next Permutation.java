/*
https://leetcode.com/problems/next-permutation/
https://leetcode.com/problems/next-permutation/solutions/3473399/beats-100-full-explanation-in-steps-by-r-mdqu

Time Complexity: O(n) where n = length of input array. 

Space Complexity: O(1)

*/
class Solution {

    private void swap(int[] nums, int leftPtr, int rightPtr) {
        int tmp = nums[leftPtr];
        nums[leftPtr] = nums[rightPtr];
        nums[rightPtr] = tmp;
    }

    private void reverseArray(int[] nums, int idx) {
        int leftPtr = idx;
        int rightPtr = nums.length - 1;

        while (leftPtr < rightPtr) {
            swap(nums, leftPtr, rightPtr);
            leftPtr++;
            rightPtr--;
        }
    }

    public void nextPermutation(int[] nums) {

        // Define iterators with default value of -1
        // NOTE: Remember, Java doesn't support negative indexing
        int idx1 = -1;
        int idx2 = -1;

        // Find break point in reverse order
        // NOTE: A break point is where the current element is less than the one right after it
        // I.e., Look for the start of the longest ascending subarray
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }

        // If there isn't a break point, then reverse entire array
        // If a break point doesn't exist, then the array is already in descreasing order. 
        //  Therefore, the given permutation (i.e., input array) is actually the last possible permutation.
        //  The next permutation would then be the first possible permutation.
        // NOTE: It's best to create an algorithm of all possible permutations in sorted order to understand the above explanation. 
        if (idx1 == -1) {
            reverseArray(nums, 0);
        } else {

            // Find next greater element and swap it with idx2
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }

            swap(nums, idx1, idx2);

            // Reverse right-half of array
            reverseArray(nums, idx1 + 1);
        }
    }
}
