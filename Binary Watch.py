# https://leetcode.com/problems/binary-watch/

class Solution:
    def readBinaryWatch(self, turnedOn: int) -> List[str]:
        
        # Create a list to hold acceptable combinations
        combos = list()
        
        # Iterate range
        for hour in range(12):
            for minute in range(60):
                
                # Convert hour and minute into binary form
                curTime = bin(hour) + bin(minute)
                
                # Each "1" inside of curTime represents an LED bulb that is turned on.
                # If the number of bulbs equals to turnedOn, then curTime is an acceptable combination
                if curTime.count("1") == turnedOn:
                    
                    tmpStr = "{}:{}".format(str(hour), str(minute).zfill(2))
                    combos.append(tmpStr)
                    
        return combos
