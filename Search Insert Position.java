// https://leetcode.com/problems/search-insert-position/

class Solution {
    
    public int binarySearch(int[] nums, int frontIdx, int rearIdx, int target) {
        
        // If indexes overlap, return rearIdx since frontIdx shouldn't be replaced
        // E.g., target = 2 & [1, 3] => [1, 2, 3]
        if (frontIdx > rearIdx) {
            return rearIdx + 1; // <= "+ 1" because question is asking for index with counting start at 1.
        }
        
        // Get middle element
        int midIdx = frontIdx + ((rearIdx - frontIdx) / 2);
        int midElem = nums[midIdx];
        
        // Check if midElem equals to target
        if (midElem == target) {return midIdx;}
        
        // Continue to slice array if target is not found
        if (midElem > target) {
            return binarySearch(nums, frontIdx, midIdx - 1, target);
        }
        else {
            return binarySearch(nums, midIdx + 1, rearIdx, target);
        }
    }
    
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}
