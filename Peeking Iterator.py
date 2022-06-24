# https://leetcode.com/problems/peeking-iterator/

# Below is the interface for Iterator, which is already defined for you.
#
# class Iterator:
#     def __init__(self, nums):
#         """
#         Initializes an iterator object to the beginning of a list.
#         :type nums: List[int]
#         """
#
#     def hasNext(self):
#         """
#         Returns true if the iteration has more elements.
#         :rtype: bool
#         """
#
#     def next(self):
#         """
#         Returns the next element in the iteration.
#         :rtype: int
#         """

class PeekingIterator:
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        
        # Save input and create a temporary variable
        self.it = iterator
        self.tmpPeek = None
        
        # Save current peek element in tmpPeek
        if self.it.hasNext():
            self.tmpPeek = self.it.next()

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        
        # Return tmpPeek since it already has element at peek
        return self.tmpPeek

    def next(self):
        """
        :rtype: int
        """
        
        # Copy old peek element
        oldPeek = self.tmpPeek
        
        # If there's a next element, save it in tmpPeek
        if self.it.hasNext():
            self.tmpPeek = self.it.next()
        else:
            self.tmpPeek = None
        
        return oldPeek
        

    def hasNext(self):
        """
        :rtype: bool
        """
        
        # If tmpPeek is null, then there are no more elements inside of the list
        if self.tmpPeek is not None:
            return True
        
        return False
        

# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].
