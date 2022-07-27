class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.sort(key=lambda x :x[0])
        
        res = []
        for interval in intervals:
            if not newInterval or newInterval[0] > interval[1]:
                res.append(interval)
            elif newInterval[1] < interval[0]:
                res.append(newInterval)
                res.append(interval)
                newInterval = None
            else:
                newInterval[0] = min(newInterval[0], interval[0])
                newInterval[1] = max(newInterval[1], interval[1])
        if newInterval:
            res.append(newInterval)
        return res