// https://leetcode.com/problems/find-the-duplicate-number/

/*
Time Complexity: O(n log n) where n = length of nums. This solution required using a sorting algorithm (e.g., quick sort and merge sort) and then
    binary search. Merge sort and quick sort both share the same time complexity and takes longer than binary search, so I'm using them as the final time complexity.

Space Complexity: O(n) where n = length of nums. In a worst-case scenario, nums is already sorted but n calls to binarySearch will still be made.
*/

class Solution {

    private int binarySearch(int[] nums, int target, int leftPtr, int rightPtr) {
        if (leftPtr < rightPtr) {

            // IMPORTANT: It's important to use leftPtr as the foundation when calculating the mid-point. If not,
            //  program will get stuck in an infinite loop checking if the target exist within the same range.
            int midPtr = leftPtr + ((rightPtr - leftPtr) / 2);

            if (nums[midPtr] == target) {
                return midPtr;
            }
            else if (nums[midPtr] < target) {
                return binarySearch(nums, target, midPtr + 1, rightPtr);
            }
            else {
                return binarySearch(nums, target, leftPtr, midPtr - 1);
            }
        }

        return nums[leftPtr] == target ? leftPtr : -1;
    }

    private boolean doesElemExist(int[] nums, int target, int leftPtr, int rightPtr) {
        return binarySearch(nums, target, leftPtr, rightPtr) != -1 ? true : false;
    }

    public int findDuplicate(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int size = nums.length;
        
        // IMPORTANT: The problem guarantees that a duplicate number exist inside nums. If nums.length is 2, then
        //  it only holds duplicate numbers and performing a binary search wouldn't make sense.
        if (size <= 2) {
            return nums[0];
        }

        // IMPORTANT: I need the array to be sort in order for a divide-and-conquer algorithm to work.
        Arrays.sort(nums);

        for (int i = 0; i < size; i++) {

            // Slice array and search right-half of the array
            if (doesElemExist(nums, nums[i], i + 1, size - 1)) {
                return nums[i];
            }
        }

        return 0;
    }
}
