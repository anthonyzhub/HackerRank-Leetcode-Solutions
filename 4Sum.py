# Link: https://leetcode.com/problems/4sum/submissions/

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        
        # Return an empty list, if length of nums is less than 4
        if len(nums) < 4:
            return []
        
        # Create a list to return
        ans = list()
        
        # Sort array
        nums.sort()
        
        for i in range(len(nums) - 3):
            
            # If current element equals to last, skip iteration
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            for j in range(i + 1, len(nums) - 2):
                
                # If current element equals to last, skip iteration
                if j > i + 1 and nums[j] == nums[j-1]:
                    continue
                
                # Create endpoint pointers
                startPtr = j + 1
                endPtr = len(nums) - 1
                
                # Move both endpoint pointers
                while startPtr < endPtr:
                    
                    # Get current sum
                    currSum = nums[i] + nums[j] + nums[startPtr] + nums[endPtr]
                    
                    # Compare currSum to target
                    if currSum == target:
                            
                        # Add list of combinations to ans
                        ans.append([nums[i], nums[j], nums[startPtr], nums[endPtr]])

                        # Update left and right pointer
                        startPtr += 1
                        endPtr -= 1
                        
                        # Check again if pointers are placed on top of duplicate numbers
                        # E.g. sum([-2, -1, 1, 2]) == sum([-2, -1, 2, 1]) <= Not a unique quadruplet
                        
                        # Move startPtr while it's less than endPtr and doesn't equal to last element
                        # REMEMBER: nums is in sorted order
                        while startPtr < endPtr and nums[startPtr] == nums[startPtr - 1]:
                            startPtr += 1
                            
                        # Move endPtr while it's greater than startPtr and doesn't equal to previous element
                        while endPtr > startPtr and nums[endPtr] == nums[endPtr + 1]:
                            endPtr -= 1
                        
                    elif currSum < target:
                        
                        # Move to the right
                        startPtr += 1
                        
                    else:
                        
                        # Move to the left
                        endPtr -= 1
                        
        return ans
