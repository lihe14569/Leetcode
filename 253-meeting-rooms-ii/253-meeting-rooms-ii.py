class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start = []
        end = []
        for interval in intervals:
            start.append(interval[0])
            end.append(interval[1])
        
        start.sort()
        end.sort()
        
        room = 0
        endIdx = 0
        for i in range(len(start)):
            if start[i] < end[endIdx]:
                room += 1
            else:
                endIdx += 1
        return room