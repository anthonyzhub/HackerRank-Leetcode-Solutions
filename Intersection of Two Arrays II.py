# https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        """
        OBJECTIVE: Return intersection of both arrays
        Time Complexity: O(mn) where m = length of nums1 and n = length of nums2.
        Space Complexity: O(i) where i = number of intersecting elements between nums1 and nums2 that are
                            stored in res.
        """
        
        # If both lists equal to each other, exit function
        if nums1 == nums2:
            return nums1
        
        # If either list is empty, return an empty list
        if len(nums1) == 0 or len(nums2) == 0:
            return list()
        
        # Create a list
        res = list()
        
        # Traverse both lists
        n = len(nums1)
        for elem in nums1:
            
            # Check if n is greater than 0 and elem exist in nums2
            if n > 0 and elem in nums2:
                
                # Add elem to res
                res.append(elem)
                
                # Update size holder and remove elem from nums2
                n -= 1
                nums2.remove(elem)
                
        return res
