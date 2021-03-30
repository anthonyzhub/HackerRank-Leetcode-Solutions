# Link: https://leetcode.com/problems/car-fleet/submissions/

"""
There are N cars
Destination is "target" miles away
Each car has a position and speed
Car fleet are cars that have same position and speed
"""

class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        
        # Use zip() to pair each element of position and speed as one car
        cars = list(zip(position, speed))
        cars.sort()
        
        # Get number of cars
        N = len(cars)
        
        # Create a list to keep track of fleets
        fleets = list()
        
        # Iterate list
        for i in range(N - 1, -1, -1): # Start from fastest to slowest car
            
            # Get car at ith position
            pos, sp = cars[i]
            
            # Calculate how many iterations it will take for the car to get to the target
            # NOTE: arrivalTime is necessary because if all the cars reached the destination at the same time, but different rate, it is considered 1 fleet
            arrivalTime = (target - pos) / sp
            
            # If this is first iteration or current car is faster than previous fleet, add it to list
            if len(fleets) == 0 or fleets[-1] < arrivalTime:
                fleets.append(arrivalTime)
                
        return len(fleets)
