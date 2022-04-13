# https://leetcode.com/problems/water-and-jug-problem/
import math

class Solution:
    def canMeasureWater(self, jug1Capacity: int, jug2Capacity: int, targetCapacity: int) -> bool:
        
        # Check if both jugs share the same capacity
        if jug1Capacity == jug2Capacity:
            
            # If target shares the same capacity as 1 or 2, then return true
            # NOTE: "you must have targetCapacity liters of water contained within one or both buckets"
            return targetCapacity == jug1Capacity
        
        # If both jugs can't hold target capacity, return false because water will be spilled
        if targetCapacity > jug1Capacity + jug2Capacity:
            return False
        
        # If target capacity is divisible by GCD of jug 1 and jug 2, then return true
        return targetCapacity % math.gcd(jug1Capacity, jug2Capacity) == 0
