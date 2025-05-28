// https://leetcode.com/problems/intersection-of-two-arrays/
/*
Time Complexity: O(n) where n = max(nums1.length, nums2.length).

Space Complexity: O(n) where n = length of resArr.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> resList = new ArrayList<Integer>();

        // Add all numbers from nums1 to set
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        // For every number from nums2 that is found in set, add it to resList and remove it from set to prevent duplicacy.
        for (int i = 0; i < nums2.length; i++) {
            
            int curNum = nums2[i];
            if (set.contains(curNum)) {
                resList.add(curNum);
                set.remove(curNum);
            }
        }

        // Convert list to array
        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }

        return resArr;
    }
}
