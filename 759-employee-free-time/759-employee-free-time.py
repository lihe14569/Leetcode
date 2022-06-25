"""
# Definition for an Interval.
class Interval:
    def __init__(self, start: int = None, end: int = None):
        self.start = start
        self.end = end
"""

class Solution:
    def employeeFreeTime(self, schedule: '[[Interval]]') -> '[Interval]':
        lst = sorted([i for s in schedule for i in s], key=lambda x : x.start)
        prev, res = lst[0], []
        for i in lst[1:]:
            if prev.end >= i.start:
                prev.end = max(prev.end, i.end)
            else:
                res.append(Interval(prev.end, i.start))
                prev = i
        return res