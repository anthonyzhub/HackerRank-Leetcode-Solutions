// https://leetcode.com/problems/contains-duplicate/description/

class Solution {
    public boolean containsDuplicate(int[] nums) {

        /*
         * Time Complexity: O(n) where n = length of nums
         * Space Complexity: O(n) where n = length of hash set
         */
        
        // If array only has 1 element, return false
        if (nums.length == 1) {return false;}

        // Create a hash set and iterate array
        HashSet<Integer> numberSet = new HashSet<Integer>();

        for (int i: nums) {

            // If the number exist in the set, return true
            if (numberSet.contains(Integer.valueOf(i))) {
                return true;
            }

            // If number doesn't exist in set, add it
            numberSet.add(Integer.valueOf(i));
        }

        return false;
    }
}
