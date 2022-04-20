// https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {
        
        // Sort array
        Arrays.sort(nums);
        
        // Traverse array
        int i=0;
        for (; i<nums.length; i++) {
            
            // If "i" doesn't appear in nums, then that is the missing number
            if (i != nums[i]) {
                return i;
            }
        }
        
        // If function is still continuing, then missing digit is the last.
        // E.g., [0, 1] has a length of 2, but 2 is not inside the list. Therefore, it is the missing digit.
        return nums.length;
    }
}
