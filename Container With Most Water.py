# Link: https://leetcode.com/problems/container-with-most-water/submissions/

class Solution:
    def maxArea(self, height: List[int]) -> int:
        
        # Declare variable to hold max area
        maxArea = 0
        
        # Create 2 pointers
        leftPtr = 0
        rightPtr = len(height)-1
        
        # Iterate list from both sides
        while leftPtr < rightPtr:
            
            # Get minimum height
            minHeight = min(height[leftPtr], height[rightPtr])
            
            # Calculate area
            currArea = minHeight * (rightPtr - leftPtr)
            
            # Save the max area
            maxArea = max(maxArea, currArea)
            
            # Move the smallest pointer towards the middle of the list
            if height[leftPtr] < height[rightPtr]:
                leftPtr += 1
            else:
                rightPtr -= 1
            
        return maxArea
