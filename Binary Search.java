// https://leetcode.com/problems/binary-search/

class Solution {
    
    public int binarySearch(int[] nums, int front_idx, int rear_idx, int target) {
        
        // If array is empty, exit function
        if (front_idx > rear_idx) {return -1;}
        
        // Get midpoint
        int mid_idx = (rear_idx - front_idx) + front_idx;
        int mid_elem = nums[mid_idx];
        
        // If target is found, return element's index
        if (mid_elem == target) {
            return mid_idx;
        }
        
        // Slice array
        if (mid_elem > target) {
            return binarySearch(nums, front_idx, mid_idx - 1, target);
        }
        else {
            return binarySearch(nums, mid_idx + 1, rear_idx, target);
        }
    }
    
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}
