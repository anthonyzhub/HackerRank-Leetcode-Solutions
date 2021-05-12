# Link: https://leetcode.com/problems/sort-colors/submissions/

class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        # If list is empty or a NoneType, exit function
        if len(nums) > 1:
            
            # Get midpoint
            midPoint = len(nums) // 2
            
            # Split list in 2 ways
            leftHalf = nums[:midPoint]
            rightHalf = nums[midPoint:]
            
            # Sort both halves
            self.sortColors(leftHalf)
            self.sortColors(rightHalf)
            
            # Create iterators for nums, leftHalf, and rightHalf
            sortIdx = 0
            leftIdx = 0
            rightIdx = 0
            
            # Iterate all lists
            while leftIdx < len(leftHalf) and rightIdx < len(rightHalf):
                
                # Compare values between leftHalf and rightHalf
                if leftHalf[leftIdx] < rightHalf[rightIdx]:
                    nums[sortIdx] = leftHalf[leftIdx]
                    leftIdx += 1
                    
                else:
                    nums[sortIdx] = rightHalf[rightIdx]
                    rightIdx += 1
                    
                # Increment iterator
                sortIdx += 1
            
            # If either iterators haven't reached the end of the list, add remaining elements to nums
            while leftIdx < len(leftHalf):
                nums[sortIdx] = leftHalf[leftIdx]
                
                sortIdx += 1
                leftIdx += 1
                
            while rightIdx < len(rightHalf):
                nums[sortIdx] = rightHalf[rightIdx]
                
                sortIdx += 1
                rightIdx += 1
