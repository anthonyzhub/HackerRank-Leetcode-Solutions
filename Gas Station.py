# https://leetcode.com/problems/gas-station/

class Solution:
    
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        
        # Define variables
        currTank = 0 # <= How much gas was gained between stations
        tripTank = 0 # <= How much gas was collected in entire trip
        startingPoint = 0 # <= At what station the trip started
        numOfStations = len(gas) # <= How many gas stations need to be visited
        
        # Visit all gas statiosn
        for idx in range(numOfStations):
            
            # Update gas used to move between stations
            currTank += gas[idx] - cost[idx]
            
            # Update gas used for entire trip
            tripTank += gas[idx] - cost[idx]
            
            # If gas reaches 0 or below while moving between stations, reset variables
            if currTank < 0:
                
                # Save new starting point
                # NOTE: "+ 1" because counting of gas station starts at 0
                startingPoint = idx + 1
                
                # Since a new starting point was created, driver didn't need gas to get there
                currTank = 0
                
        # If trip ended with enough gas, return starting point
        if tripTank >= 0:
            return startingPoint
        
        # If trip wasn't complete, return -1
        return -1
