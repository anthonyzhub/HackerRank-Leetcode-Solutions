# Link: https://leetcode.com/problems/3sum-closest/submissions/

class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:

        # If list only has 3 elements, return sum of elements
        if len(nums) == 3:
            return sum(nums)
        
        # Sort array
        nums.sort()
        
        # Get sum of the 1st three elements
        closestTarget = sum(nums[:3])
        
        # Iterate list
        for i in range(len(nums) - 2): # <= Prevent out-of-bounds error
            
            # Create two pointers at both ends of the list
            firstPtr = i + 1
            secondPtr = len(nums) - 1
            
            # [-4, -1, 1, 2]
            while firstPtr < secondPtr:
                
                # Get current possible sum
                currSum = nums[i] + nums[firstPtr] + nums[secondPtr]
                
                # Get closest target
                if abs(closestTarget - target) > abs(currSum - target): 
                    closestTarget = currSum
                
                # Update pointes
                if currSum < target:
                    firstPtr += 1
                else:
                    secondPtr -= 1
                    
        return closestTarget
