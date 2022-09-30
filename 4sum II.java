// https://leetcode.com/problems/4sum-ii/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        /*
        OBJECTIVE: Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that 
                    0 <= i, j, k, l < n and nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
        
        Time Complexity: O(n^2) where n = length of any array. 2 nested loops are used to create all possible combinations
        
        Space Complexity: O(k) where k = the number of keys in the hash map. Each key represents a sum of a possible combination between nums1 and nums2. 
                          Combinations from nums3 and nums4 aren't really stored. Their negation were already created during the 1st nested for-loop

        */
        
        // Create a hash map
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Create a return variable
        int res = 0;
        
        // Store all combinations of nums1 and nums2 in map
        for (int i: nums1) {
            for (int j: nums2) {
                
                // Store summation of i and j and it's frequency in map
                if (map.containsKey(i + j)) {
                    map.put(i + j, map.get(i + j) + 1);
                }
                else {
                    map.put(i + j, 1);
                }
            }
        }
        
        // Create all possible combinations of nums3 and nums4
        for (int i: nums3) {
            for (int j: nums4) {
                
                /*
                If there's a negation of (i+j) inside dic, add it's value to res
                Remember, we're looking for how MANY tuples there are that sums to 0. 
                E.g., If there's 2 pairs with each having a sum of 3 and another 2 pairs with each having a sum of -3, then there are a total of 4 pairs in 
                      which added together will equal to 0
                */
                
                if (map.containsKey(- (i + j))) {
                    res += map.get(- (i + j));
                }
            }
        }
        
        return res;
    }
}
