"""
# Definition for an Interval.
class Interval:
    def __init__(self, start: int = None, end: int = None):
        self.start = start
        self.end = end
"""

class Solution:
    def employeeFreeTime(self, schedule: '[[Interval]]') -> '[Interval]':
        times = sorted([i for s in schedule for i in s], key=lambda x : x.start)
        curr = times[0]
        res = []
        for i in times[1:]:
            if curr.end >= i.start:
                curr.end = max(curr.end, i.end)
            else:
                res.append(Interval(curr.end, i.start))
                curr = i
        return res