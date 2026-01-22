/*
Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
https://youtu.be/q6IEA26hvXc?si=cl0gD8zRYOvxooir

Time Complexity: O(log(m, n)) where m & n are the size of nums1 and nums2, respectively. Binary search
    is performed on the smallest array.

Space Complexity: O(1)

NOTE: In the original submission from 2022, the time complexity constraint didn't exist.
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arrA = nums1;
        int[] arrB = nums2;

        int totalLen = arrA.length + arrB.length;
        int halfLen = (int) totalLen / 2;

        // Find smallest array. Set arrA to smallest array
        if (arrA.length > arrB.length) {
            int[] tmp = arrA;
            arrA = arrB;
            arrB = tmp;
        }

        // Create left and right pointers from arrA
        int leftPtr = 0;
        int rightPtr = arrA.length;

        // Perform binary search on both arrays
        while (true) {

            // Get midPtr of each array
            int midA = leftPtr + (rightPtr - leftPtr) / 2;
            int midB = halfLen - midA; // -2 because array's index is 0 based and we're dealing with 2 arrays

            // Calculate left and right pointers of each partition
            // NOTE: Confirm the pointers of each partition isn't out-of-bounds
            int aLeft  = (midA > 0) ? arrA[midA - 1] : Integer.MIN_VALUE;
            int aRight = (midA < arrA.length) ? arrA[midA] : Integer.MAX_VALUE;

            int bLeft  = (midB > 0) ? arrB[midB - 1] : Integer.MIN_VALUE;
            int bRight = (midB < arrB.length) ? arrB[midB] : Integer.MAX_VALUE;

            // If partition was correctly created, find the median value;
            if (aLeft <= bRight && bLeft <= aRight) {

                // NOTE: We have to perform the below calculations because we can't merge both arrays because of time complexity constraint.
                //  We need to calculate the median by using the pointers of each partition simultaneously
                if (totalLen % 2 == 1) {
                    return Math.min(aRight, bRight);
                }

                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) { // Check that the left most value from partition A is greater than right most value of partition B
                rightPtr = midA - 1;
            } else { // Check that the left most value from partition A is less than  or equal to right most value of partition B
                leftPtr = midA + 1;
            }
        }
    }
}
