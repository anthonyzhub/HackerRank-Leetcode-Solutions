/*
https://leetcode.com/problems/find-the-duplicate-number/
https://youtu.be/wjYnzkAhcNk?si=nBLqkw5aUHEB9dop

Time Complexity: O(n) where n = length of input array. 

Space Complexity: O(1)
*/

class Solution {
    public int findDuplicate(int[] nums) {

        // Create 2 pointers
        int tortoise = 0;
        int hare = 0;

        // Iterate array until both pointers meet
        // Note: Problem statement guarantees that there is a cycle inside the array
        while (true) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];

            if (tortoise == hare) {
                break;
            }
        }

        // Reset hare and iterate array until both pointers meet again
        // NOTE: The index they will meet again is the duplicate number
        hare = 0;
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
