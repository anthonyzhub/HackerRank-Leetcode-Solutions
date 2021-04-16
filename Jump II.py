# Link: https://leetcode.com/problems/jump-game-ii/solution/

class Solution:
    def jump(self, nums: List[int]) -> int:
        
        # If list is empty, return 0
        if len(nums) == 0 or nums == None:
            return 0
        
        # If list only has 1 element, return 0
        if len(nums) == 1:
            return 0
        
        # Create iterators and counter
        jumpCount = 0
        currJumpEnds = 0 # <= Mark the end of the range that can be jumped to
        farthestJump = 0 # <= Mark the farthest place that can be reached
        
        # Iterate list
        for i in range(len(nums) - 1): # <= We only need to reach the last element
            
            # See how far we can jump
            # NOTE: nums[i] + i 
            farthestJump = max(farthestJump, nums[i] + i)
            
            if i == currJumpEnds:
                jumpCount += 1
                currJumpEnds = farthestJump
                
        return jumpCount
