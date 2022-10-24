# https://leetcode.com/problems/flatten-nested-list-iterator/

# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def isInteger(self) -> bool:
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        """
#
#    def getInteger(self) -> int:
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        """
#
#    def getList(self) -> [NestedInteger]:
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        """

class NestedIterator:
    
    def flatten(self, nestedList) -> None:
        
        """
        OBJECTIVE: Add all integer elements to res. If an element is a list, make a recursive call
        
        Time Complexity: O(2^n) where n = length of nestedList. This function handles integers and lists.
                        If ith element is an integer, that integer gets added to res. If it is a list, a
                        recursive call is made.
                        
                        I.e., Each element is either a list or an integer. So, each element has 2 choices
                        and the decision tree is expanded.
                        
        Space Complexity: O(2^n). The same reasoning as time complexity. If the ith element is a list, the
                        memory stack gets bigger
        """
        
        # Iterate nestedList
        for elem in nestedList:
            
            # If elem is a list, make a recursive call
            if not elem.isInteger():
                self.flatten(elem.getList())
                
            # If elem is an integer, add it to res
            else:
                self.res.append(elem.getInteger())
    
    def __init__(self, nestedList: [NestedInteger]):
        
        # Create an output list
        self.res = list()
        
        # Flatten list
        self.flatten(nestedList)
        
        # Get size of res and create an index pointer
        self.idx = 0
        self.size = len(self.res)
    
    def next(self) -> int:
        
        # OBJECTIVE: If there are any remaining elements after idx, return it
        
        # Check if idx hasn't reached the end of the list
        if self.hasNext() == False:
            return None
        
        # Get current variable
        curElem = self.res[self.idx]
        self.idx += 1
        
        # Return element
        return curElem
        
    
    def hasNext(self) -> bool:
        
        # OBJECTIVE: Return true if idx hasn't reached the end. If not, return false
        
        if self.idx == self.size:
            return False
        
        return True
         

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())
