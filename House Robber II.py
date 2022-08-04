# https://leetcode.com/problems/house-robber-ii/

class Solution:
    
    def robbing(self, houses):
        
        # OBJECTIVE: Iterate list linearly with 2 different iterators. Return the highest profitable iterator
        
        # Add money from 1st house to 3rd house.
        houses[2] += houses[0]
        
        # Iterate range
        for i in range(3, len(houses)):
            
            # Update value by the most profitable house that was just robbed
            houses[i] += max(houses[i - 2], houses[i - 3])
        
        # Return the most profitable robbing spree
        return max(houses[-1], houses[-2])
    
    def rob(self, nums: List[int]) -> int:
        
        # Get length of list
        numOfHouses = len(nums)
        
        # If there are less than 4 houses, return highest element
        # NOTE: Can only rob 1 house in this case, so rob the house with the most money
        if numOfHouses < 4:
            return max(nums)
        
        # If there are exactly 4 houses, return the pair with the highest value
        # NOTE: There are 2 different ways to rob the houses. House 1 and 3 or 2 and 4. Pick whichever has the most money together
        elif numOfHouses == 4:
            return max(nums[0] + nums[2], nums[1] + nums[3])
        
        # If there are more than 4 houses, return the most profitable
        # NOTE: Since this is a cycle, 1st and last house both can't be robbed or alarm will go off.
        return max(self.robbing(nums[:-1]), self.robbing(nums[1:]))
