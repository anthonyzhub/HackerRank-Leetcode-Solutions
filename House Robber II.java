// https://leetcode.com/problems/house-robber-ii/

class Solution {
    
    public int robbing(int[] houses, int startIdx, int endIdx) {
        
        // OBJECTIVE: Iterate array linearly with 2 different iterators. Return the highest profitable iterator
        
        // Add money from 1st house to 3rd house
        houses[2] += houses[startIdx];
        
        // Iterate houses
        for (int i=3; i<endIdx; i++) {
            houses[i] += Math.max(houses[i - 2], houses[i - 3]);
        }
        
        // Return the most profitable robbing spree
        return Math.max(houses[endIdx - 1], houses[endIdx - 2]);
    }
    
    public void sliceArray(int[] source, int[] dest, int startIdx, int endIdx) {
        
        // OBJECTIVE: Add elements from start to end to dest array
        
        for (int i=startIdx; i<endIdx; i++) {
            dest[i] = source[i];
        }
    }
    
    public int rob(int[] nums) {
        
        // Get length of house
        int n = nums.length;
        
        // If there are less than 4 houses, return the house with the most money
        // NOTE: Can't rob adjacent houses!
        if (n < 4) {
            
            int maximumElem = 0;
            for (int i=0; i<n; i++) {
                maximumElem = Math.max(maximumElem, nums[i]);
            }
            
            return maximumElem;
        }
        
        // If there are exactly 4 houses, return the pair with the most money
        else if (n == 4) {
            return Math.max(nums[0] + nums[2], nums[1] + nums[3]);
        }
        
        // Create 2 new arrays
        int[] sliceA = new int[n];
        int[] sliceB = new int[n];
        
        // Slice nums[] and add elements to sliceA and sliceB
        sliceArray(nums, sliceA, 0, n - 1);
        sliceArray(nums, sliceB, 1, n);
        
        // If there are more than 4 houses, return the most profitable robbing spree
        return Math.max(robbing(sliceA, 0, sliceA.length), robbing(sliceB, 0, sliceB.length));
    }
}
