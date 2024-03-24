// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum1(int[] nums, int target) {

        /* BRUTE FORCE */
        
        // Create a return list
        int[] ans = new int[2];

        // Iterate nums
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;

                    return ans;
                }
            }
        }

        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        
        /* HASH MAP APPROACH 
         * 
         * Time Complexity: O(n) = n is the length of nums. 
         * 
         * Space Complexity: O(n) = n is map size.
        */

        // Create a hash map
        Map<Integer, Integer> map = new HashMap<>();

        // Put all the elements to hash map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Find the complement
        // I.e., nums[i] + X = target. X is the complement.
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exist in map and it isn't itself, then return list
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
        }
        
        return null;
    }
}