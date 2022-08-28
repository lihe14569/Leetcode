class Solution:
    def removeInterval(self, intervals: List[List[int]], toBeRemoved: List[int]) -> List[List[int]]:
        res = []
        intervals.sort(key = lambda x : x[0])
        for interval in intervals:
            if toBeRemoved:
                if interval[1] <= toBeRemoved[0]:
                    res.append(interval)
                elif interval[0] >= toBeRemoved[1]:
                    res.append(interval)
                    toBeRemoved = None
                else:#remove interval
                    if interval[0] < toBeRemoved[0]:
                        res.append([interval[0], toBeRemoved[0]])
                    if interval[1] > toBeRemoved[1]:
                        res.append([toBeRemoved[1], interval[1]])
                    
            else:
                res.append(interval)
        return res
        