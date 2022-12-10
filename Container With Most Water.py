# https://leetcode.com/problems/container-with-most-water/description/

class Solution:
    def maxArea(self, height: List[int]) -> int:

        """
        OBJECTIVE: Return the maximum amount of water a container can store.

        Time Complexity: O(n) where n = length of height. The list is iterated once with 2 pointers. By using two pointers in one loop, 
                        it helps inspect the list quickly.

        Space Complexity: O(1) because no additional space was used
        """
        
        # Get list's size
        n = len(height)

        # Create a left and right pointer and current width
        leftPtr = 0
        rightPtr = n - 1
        width = rightPtr - leftPtr

        # Create a variable to hold maximum area
        # NOTE: Formula for area of a rectangle is width * height and the minimum height is calculated because it is the maximum amount of water that
        #       will hold. E.g., If there are 2 walls with a height of 1 and 8. Between those 2 walls, the water will spill after surpassing the wall
        #       with the height of 1.
        res = width * min(height[leftPtr], height[rightPtr])

        # Iterate list and compute maximum area
        while leftPtr < rightPtr:

            # If left value is smaller than the right, move the left pointer
            if height[leftPtr] < height[rightPtr]:
                leftPtr += 1
            
            # If right value is smaller than the left, move the right pointer
            else:
                rightPtr -= 1
            
            # Update the width every time either pointer moves
            width = rightPtr - leftPtr

            # Calculate the maximum area
            res = max(res, width * min(height[leftPtr], height[rightPtr]))

        return res
