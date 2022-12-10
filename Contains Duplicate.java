// https://leetcode.com/problems/contains-duplicate/description/

class Solution {
    public boolean containsDuplicate(int[] nums) {

        /*
        OBJECTIVE: Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

        Time Complexity: O(n) where n = length of nums. A for-loop was created to transfer all elements from nums to a set.

        Space Complexity: O(n) where n = length of nums. A set was created because it doesn't accept duplicate entries. 
                          Worst case scenario is that nums doesn't have any duplicate entries
        */
        
        // Convert array to set
        HashSet<Integer> numsSet = new HashSet<>();
        for (int i: nums) {
            numsSet.add(i);
        }

        // If set and array don't share the same size, then array has a duplicate entry
        if (nums.length != numsSet.size()) {
            return true;
        }
        return false;
    }
}
