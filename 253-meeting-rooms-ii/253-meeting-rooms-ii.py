class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        time = []
        for interval in intervals:
            time.append((interval[0], 1))
            time.append((interval[1], -1))
        
        time.sort(key = lambda x : (x[0], x[1]))
        
        cnt = 0
        res = 0
        for t in time:
            cnt += t[1]
            res = max(res, cnt)
        return res