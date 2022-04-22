# https://leetcode.com/problems/find-the-duplicate-number/

"""
- Algorithm is based on Floyd's Tortoise and Hare Cycle Detection
- Time complexity is O(n) while space complexity is O(1)
"""

class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        
        # If nums is empty, return 0
        if len(nums) <= 1:
            return 0
        
        # Create 2 pointers as tortoise and hare
        # NOTE: Think of this as the starting line for both animals
        tortoise = nums[0]
        hare = nums[0]
        
        # Traverse list until tortoise and hare intersect
        while True:
            
            # Update positions
            # NOTE: A list should technically be in order. Tortoise is moving one element at a time. Hare is moving based on the appropriate index of the element.
            # 
            # E.g., [2, 1, 4, 3]. At nums[0] == 2, the number 2 should be at the 2nd index or nums[1].
            #       Hare is taking element value 2 and moving to what is suppose to be the appropriate index or nums[1]
            tortoise = nums[tortoise]
            hare = nums[nums[hare]]
            
            # If both animals intersect, exit loop
            if tortoise == hare:
                break
        
        # Send tortoise back to the front of the list
        tortoise = nums[0]
        
        # Traverse list again to find where cycle beings
        while tortoise != hare:
            
            # Move both animals 1 element at a time
            tortoise = nums[tortoise]
            hare = nums[hare] # <= Since Hare is stuck in a cycle, it will go around in a circle
            
        # Return either animals because both are at beginning of the cycle
        return hare
