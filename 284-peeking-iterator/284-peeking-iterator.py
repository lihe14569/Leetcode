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
        self._iterator = iterator
        self._peeked_val = None

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        if self._peeked_val is None:
            if not self.hasNext():
                raise StopIteration()
            self._peeked_val = self._iterator.next()
        
        return self._peeked_val
        

    def next(self):
        """
        :rtype: int
        """
        res = 0
        if self._peeked_val is not None:
            res = self._peeked_val
            self._peeked_val = None
            return res
        
        if not self._iterator.hasNext():
            raise StopIteration()
        return self._iterator.next()

    def hasNext(self):
        """
        :rtype: bool
        """
        return self._peeked_val is not None or self._iterator.hasNext()
        
        

# Your PeekingIterator object will be instantiated and called as such:
# iter = PeekingIterator(Iterator(nums))
# while iter.hasNext():
#     val = iter.peek()   # Get the next element but not advance the iterator.
#     iter.next()         # Should return the same value as [val].