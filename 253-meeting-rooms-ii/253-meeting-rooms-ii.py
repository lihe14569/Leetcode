class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start, end = [], []
        for i in range(len(intervals)):
            start.append(intervals[i][0])
            end.append(intervals[i][1])
            
        start.sort()
        end.sort()
        
        room, end_idx = 0, 0
        for i in range(len(intervals)):
            if start[i] < end[end_idx]:
                room += 1
            else:
                end_idx +=1
        return room