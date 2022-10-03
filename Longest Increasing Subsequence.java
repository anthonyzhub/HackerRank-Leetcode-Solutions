// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        /*
         OBJECTIVE: Given an integer array nums, return the length of the longest strictly increasing subsequence.
        
        Time Complexity: O(n log n) where n = length of nums. Inside the for-loop, binary search is being used to properly insert elements from nums to tails. 
        
                        I didn't nums' iteration because the largest time complexity is kept as the final answer. E.g., O(n) < O(n log n), so O(n + n log n) isn't really different from O(n log n). Most of the time spent is coming from O(n log n).
                        
        Space Complexity: O(n) where n = length of tails. An additional list was created to solve the problem.
        
        */
        
        // Get size of array
        int n = nums.length;
        
        // If nums only has 1 element, return 1
        if (n == 1) {return 1;}
        
        // Create a tails array
        int[] tails = new int[n];
        
        // Create a return variable
        int res = 0;
        
        // Iterate nums
        for (int num: nums) {
            
            // Create indices pointers
            int leftPtr = 0;
            int rightPtr = res;
            
            // Use binary search to find an element from tails that needs to be updated
            while (leftPtr != rightPtr) {
                
                // Calculate midpoint
                int midPtr = (int) (leftPtr + rightPtr) / 2;
                
                // If num is greater than element at midpoint, update left pointer
                if (num > tails[midPtr]) {
                    leftPtr = midPtr + 1;
                }
                
                // If num is less than or equal to element at midpoint, update right pointer
                else {
                    rightPtr = midPtr;
                }
            }
            
            /*
            Mini Objective: Update element in tails
            If num is greater than all the elements in tail, add it to tails. I.e., replace 0 for num
            If num can be inserted in tails, replace old element for nums. E.g., tails[leftPtr - 1] < num <= tails[leftPtr]
            */
            tails[leftPtr] = num;
            
            // Update return output
            res = Math.max(leftPtr + 1, res);
        }
        return res;
    }
}
