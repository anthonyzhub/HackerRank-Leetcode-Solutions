# Link: https://leetcode.com/problems/my-calendar-i/submissions/

# IMPORTANT: [start, end)

class MyCalendar:

    def __init__(self):
        
        # Create a list to hold events
        self.events = list()
        
    def book(self, start: int, end: int) -> bool:
        
        # If there's no event saved, return true
        if len(self.events) == 0:
            
            # Save start and end time
            self.events.append((start, end))
            
            return True
        
        # Iterate list
        for savedStartTime, savedEndTime in self.events:
            
            # If proposed event overlaps any saved event, return false
            # NOTE: savedStartTime < end == "The new event ends in a saved event"
            #       start < savedEndTime == "The new event starts in a saved event"
            if savedStartTime < end and start < savedEndTime:
                return False
        
        # Add new event
        self.events.append((start, end))
        return True

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)
