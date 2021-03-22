# Link: https://leetcode.com/problems/merge-sorted-array/submissions/

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        # If nothing needs to be added to nums1, exit function
        if n <= 0:
            return
        
        # Create index pointer to last element of nums1
        lastIdx = len(nums1) - 1
        
        # Iterate both lists
        while m > 0 and n > 0:
            
            # Compare both values
            if nums1[m - 1] > nums2[n - 1]:
                
                # Update last element
                nums1[lastIdx] = nums1[m - 1]
                
                # Update index pointers
                lastIdx -= 1
                m -= 1
                
            else:
                
                # Update last element
                nums1[lastIdx] = nums2[n - 1]
                
                # Update index pointers
                lastIdx -= 1
                n -= 1
                
        # Check if nums2 has any leftover elements
        while n > 0:
            
            # Update last element
            nums1[lastIdx] = nums2[n - 1]
            
            # Update index pointers
            lastIdx -= 1
            n -= 1
