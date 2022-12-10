// https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    public int[] productExceptSelf(int[] nums) {

        /*
        OBJECTIVE: Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
        
        Time Complexity: O(n) where n = length of nums. 2 for-loops were created to iterate the nums. Each loop's runtime is O(n)
        
        Space Complexity: O(n) where n = length of res. A return array had to be created and its size is based off nums' size
        */
        
        // Get length of nums
        int n = nums.length;

        // Create a return array filled with 1's
        int[] res = new int[n];
        Arrays.fill(res, 1);

        // Calculate prefix and update res
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        // Calculate postfix and update res
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}
