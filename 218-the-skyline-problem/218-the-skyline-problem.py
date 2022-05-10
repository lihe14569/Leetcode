class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        events = [(L, -H, R) for L, R, H in buildings]
        events += [(R, 0, 0) for _, R, _ in buildings]
        events.sort()
        
        res= [[0, 0]]
        live = [(0, float('inf'))]
        
        for pos, negh, r in events:
            while live[0][1] <= pos:
                heapq.heappop(live)
            if negh: 
                heapq.heappush(live, (negh, r))
            if res[-1][1] != -live[0][0]:
                res += [[pos, -live[0][0]]]
        return res[1:]
            