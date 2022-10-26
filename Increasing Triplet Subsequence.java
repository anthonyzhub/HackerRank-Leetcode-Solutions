// https://leetcode.com/problems/increasing-triplet-subsequence/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        /*
        OBJECTIVE: Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
        
        Time Complexity: O(n) where n = length of nums. List is being iterated to find an appropriate list of indices
        
        Space Complexity: O(1) because no additional space was taken
        */
        
        // If array's length is less than 3, return false
        if (nums.length < 3) {return false;}
        
        // Create 2 pointers
        int leftPtr = Integer.MAX_VALUE;
        int rightPtr = Integer.MAX_VALUE;
        
        // Iterate nums
        // I.e., Update left and right pointers to existing element inside list. Also, stop iteration when iterator reaches a point
        for (int midPtr: nums) {
            
            // If midPtr is less than or equal to leftPtr, update leftPtr
            if (midPtr <= leftPtr) {
                leftPtr = midPtr;
            }
            
            // If midPtr is less than or equal to rightPtr, update rightPtr
            else if (midPtr <= rightPtr) {
                rightPtr = midPtr;
            }
            
            // If leftPtr < midPtr < rightPtr, return true
            else {
                return true;
            }
        }
        
        // If function is still continuing, return false
        return false;
    }
}
