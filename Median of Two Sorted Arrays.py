# https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution:
    
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        """
        OBJECTIVE: Return median of 2 sorted arrays
        
        Time Complexity: O(m + n + (c log c)) where m = length of nums1, n = length of nums2, c = length of the list of where the median is being
                        calculated.
                        
                        O(m + n) comes from the 1st two lines of m and n. Those lines are calculating the length of both lists.
                        
                        O(c log c) comes from timsort. If both lists are non-empty, they are merged and sorted with the timsort algorithm. 
        
        Space Complexity: It is between O(n) and O(1), depending on whether or not nums1 and nums2 are non-empty. If both lists are non-empty, then the
                        space complexity is O(n) where n = length of nums1 and nums2 because timsort is used to sort the merged lists.
                        
                        If either list is empty, then the space complexity is O(1) because no additional space was created. The non-empty list is
                        already sorted based on the problem.
        """
        
        # Get size of both arrays
        m = len(nums1)
        n = len(nums2)
        
        # Check if both lists are non-empty
        if m > 0 and n > 0:
            
            # Merge both arrays
            merged = nums1 + nums2
            merged.sort()
            
            # If m+n is divisible by 2, then there isn't a true middle element. Add 2 elements that are closer to the middle and divide them by 2
            if (m+n) % 2 == 0:
                
                # Calculate mid point and return median
                mid = (m + n) // 2
                return (merged[mid] + merged[mid - 1]) / 2
            
            return merged[(m + n) // 2]
        
        # Check if nums1 is non-empty
        elif m > 0:
            
            # If m is divisible by 2, then there isn't a true middle element. Add 2 elements that are closer to the middle and divide them by 2
            if m % 2 == 0:
                
                # Calculate mid point and return median
                mid = m // 2
                return (nums1[mid] + nums1[mid - 1]) / 2
            
            return nums1[m // 2]
        
        # Check if nums2 is non-empty
        elif n > 0:
            
            # If n is divisible by 2, then there isn't a true middle element. Add 2 elements that are closer to the middle and divide them by 2
            if n % 2 == 0:
                
                # Calculate mid point and return median
                mid = n // 2
                return (nums2[mid] + nums2[mid - 1]) / 2
            
            return nums2[n // 2]
        
        
