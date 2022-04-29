class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        #pq
        intervals.sort(key = lambda x: x[0])
        heap = []
        heapq.heappush(heap, intervals[0][1])
        for i in intervals[1:]:
            if i[0] >= heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap, i[1])
        return len(heap)
                