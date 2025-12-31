// https://leetcode.com/problems/merge-sorted-array/
// https://youtu.be/P1Ic85RarKY?si=n1gej19lWlJPSPjF
/*
Time Complexity: O(m + n) where m and n are the input variables.

Space Complexity: O(1). No additional array was created.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Create 3 pointers
        int mPtr = m - 1;
        int nPtr = n - 1;
        int kPtr = m + n - 1;

        // Iterate both arrays in reverse order
        /* IMPORTANT: nums1 has enough space for both arrays. nums1 has multiple spaces filled with 0s.
            Those spaces are meant to be overidden. It also helps with not overriding or creating a temporary variable to hold
            the first M elements.
        */
        while (nPtr >= 0 && mPtr >= 0) {
            if (nums1[mPtr] > nums2[nPtr]) {
                nums1[kPtr] = nums1[mPtr];
                kPtr--;
                mPtr--;
            } else {
                nums1[kPtr] = nums2[nPtr];
                nPtr--;
                kPtr--;
            }
        }

        // Add remaining elements from nums2 to nums1
        while (nPtr >= 0) {
            nums1[kPtr] = nums2[nPtr];
            kPtr--;
            nPtr--;
        }
    }
}
