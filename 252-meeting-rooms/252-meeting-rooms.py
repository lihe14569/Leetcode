class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        intervals=sorted(intervals, key=lambda x: x[0])
        end = float('-inf')
        for i in range(len(intervals)):
            if intervals[i][0] < end: return False
            end = intervals[i][1]
        return True