// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    
    public void moveTo(int[] source, int[] dest, int startIdx) {
        
        // OBJECTIVE: Copy all elements from source to dest
        
        for (int i=0; i<source.length; i++) {
            dest[startIdx] = source[i];
            startIdx++;
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        /*
        OBJECTIVE: Return median of 2 sorted arrays
        
        Time Complexity: O(m + n + (c log c)) where m = length of nums1, n = length of nums2, c = length of                         the list of where the median is being calculated.
                        
                        O(m + n) comes from the 1st two lines of m and n. Those lines are calculating the length of both lists.
                        
                        O(c log c) comes from timsort. If both lists are non-empty, they are merged and sorted with the timsort algorithm. 
        
        Space Complexity: It is between O(n) and O(1), depending on whether or not nums1 and nums2 are non-empty. If both lists are non-empty, then the
                        space complexity is O(n) where n = length of nums1 and nums2 because timsort is used to sort the merged lists.
                        
                        If either list is empty, then the space complexity is O(1) because no additional space was created. The non-empty list is
                        already sorted based on the problem.
        */
        
        // Get size of both arrays
        int m = nums1.length;
        int n = nums2.length;
        
        // If both arrays are empty, return 0
        if (m + n == 0) {return 0;}
        
        // Check if both arrays are non-empty
        if (m > 0 && n > 0) {
            
            // Create a new array
            int[] merged = new int[m + n];
            
            // Populate array
            moveTo(nums1, merged, 0);
            moveTo(nums2, merged, m);
            
            // Sort array
            Arrays.sort(merged);
            
            // Calculate mid point
            int mid = (m + n) / 2;
            
            // If m+n is divisible by 2, then there isn't a true middle element. Add 2 elements that are closer to the middle and divide them by 2
            if ((m + n) % 2 == 0) {
                
                // Return median
                return (float) (merged[mid] + merged[mid - 1]) / 2;
            }
            
            return (float) merged[mid];
        }
        else if (m > 0) {
            
            // Calculate mid point
            int mid = m / 2;
            
            // If m is divisible by 2, then there isn't a true middle element. Add 2 elements that are closer to the middle and divide them by 2
            if (m % 2 == 0) {
                return (float) (nums1[mid] + nums1[mid - 1]) / 2;
            }
            
            return (float) nums1[mid];
        }
        else {
            
            // Calculate mid point
            int mid = n / 2;
            
            // If n is divisible by 2, then there isn't a true middle element. Add 2 elements that are closer to the middle and divide them by 2
            if (n % 2 == 0) {
                return (float) (nums2[mid] + nums2[mid - 1]) / 2;
            }
            return (float) nums2[mid];
        }
    }
}
