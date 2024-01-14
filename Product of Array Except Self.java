// https://leetcode.com/problems/product-of-array-except-self/description/

class Solution {
    public int[] productExceptSelf(int[] nums) {

        /*
        OBJECTIVE: Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
        
        Time Complexity: O(n) where n = length of nums. 2 for-loops were created to iterate the nums. Each loop's runtime is O(n)
        
        Space Complexity: O(n) where n = length of res. A return array had to be created and its size is based off nums' size
        */
        
        // If nums only has 2 elements, swap them
        if (nums.length == 2) {
            return new int[]{nums[1], nums[0]};
        }

        // Create a return array and fill it with 1's
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        // Calculate product of prefix of ith element and save it in res
        // I.e., prefix = product(nums[:i])
        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        // Calculate product of postfix of ith element and save it in res
        // I.e., postfix = product(nums[i+1:])
        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}
