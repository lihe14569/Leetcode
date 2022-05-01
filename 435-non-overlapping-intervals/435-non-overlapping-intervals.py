class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        #greed
        intervals.sort(key=lambda x: x[1])
        
        cnt = 1;
        prev= intervals[0][1]
        for curr in intervals[1:]:
            if curr[0] < prev:
                continue
            else:
                cnt += 1
                prev= curr[1]
        return len(intervals) - cnt