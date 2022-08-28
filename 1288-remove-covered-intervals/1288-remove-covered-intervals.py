class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x : (x[0], -x[1]))
        cnt = 1
        prev = intervals[0]
        for i in intervals[1:]:
            #no covered
            if i[1] > prev[1]:
                cnt += 1
                prev = i
        return cnt
                