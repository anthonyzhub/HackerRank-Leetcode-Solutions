# Link: https://leetcode.com/problems/design-underground-system/submissions/

from collections import defaultdict
class UndergroundSystem:

    def __init__(self):
        self.checkInDict = dict()
        self.tripDict = defaultdict(lambda:[0,0]) # <= Create a dictionary with default values. If not added, error will rise in checkOut()
        
    def checkIn(self, id: int, stationName: str, t: int) -> None:
        
        # Add record
        # ID = [station, check in time]
        self.checkInDict[id] = [stationName, t]

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        
        # Get list from dictionary's key
        idFirstStation, idCheckInTime = self.checkInDict[id]
        
        # Add entry to tripDict
        # [first station, last station] = [total time, number of passengers]
        self.tripDict[(idFirstStation, stationName)][0] += (t - idCheckInTime)
        self.tripDict[(idFirstStation, stationName)][1] += 1

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        
        # Get data from dictionary
        totalTime, numOfPass = self.tripDict[(startStation, endStation)]
        return totalTime/numOfPass

# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)
