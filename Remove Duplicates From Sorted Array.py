# Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        # Base cases: if list is empty or only has 1 element
        if nums == None or len(nums) == 0:
            return 0
        
        if len(nums) == 1:
            return 1
        
        # Create index variable
        indx = 1
        
        # Iterate list
        for i in range(len(nums) - 1):
            
            # Check if both numbers doesn't match
            if nums[i] != nums[i+1]:
              
                # Replace 1st old repeative number with next unique number
                # E.g. [1, 1, 2] => [1, 2, 2]
                nums[indx] = nums[i + 1]
                
                # Update index variable to next position
                # E.g. Index was 1 before this iteration based on previous example. Now, it is 2.
                indx += 1
                
        # Return last index, which is also the new size of the list
        return indx
