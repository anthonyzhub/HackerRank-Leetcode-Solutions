// https://leetcode.com/problems/find-the-duplicate-number/

/*
- Algorithm is based on Floyd's Tortoise and Hare Cycle Detection
- Time complexity is O(n) while space complexity is O(1)
*/

class Solution {
    public int findDuplicate(int[] nums) {
        
        // If nums only 0 or 1 element, exit loop
        if (nums.length <= 1) {return nums[0];}
        
        // Create 2 variables as tortoise and hare
        // NOTE: Think of this as the starting line
        int tortoise = nums[0];
        int hare = nums[0];
        
        // Traverse array until both animals intersect
        while (true) {
            
            // Move animals
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            
            // If both animals intersect, exit loop
            if (tortoise == hare) {break;}
        }
        
        // Move tortoise back to the front of array
        tortoise = nums[0];
        
        // Traverse array again until beginning of cycle is reached
        while (tortoise != hare) {
            
            // Move both animals 1 element at a time
            tortoise = nums[tortoise];
            hare = nums[hare]; // <= Hare is stuck in a cycle, so it will be moving in circles
        }
        
        // Return either animals since both will meet at the beginning of the cycle
        return tortoise;
    }
}
