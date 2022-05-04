class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x : (x[0], -x[1]))
        prev = intervals[0]
        res = 1
        
        for interval in intervals[1:]:
            if prev[0] <= interval[0] and prev[1] >= interval[1]:
                continue
            res += 1
            prev = interval
        return res
                
                