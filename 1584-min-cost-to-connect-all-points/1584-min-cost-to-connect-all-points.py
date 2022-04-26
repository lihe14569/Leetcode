class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        #prims algo
        distance = lambda p1,p2 : abs(p1[0]- p2[0]) + abs(p1[1] - p2[1])
        n, dic = len(points), defaultdict(list)
        #build edge relation
        for i in range(n):
            for j in range(1, n):
                d = distance(points[i], points[j])
                dic[i].append((d, j))
                dic[j].append((d, i))
        
        res, cnt, visited, heap = 0, 1, [0] * n, dic[0]
        visited[0] = 1
        heapq.heapify(heap)
        
        while heap:
            d, i = heapq.heappop(heap)
            if not visited[i]:
                cnt, visited[i], res = cnt+1, 1, res + d
                for node in dic[i]: heapq.heappush(heap, node)
            if cnt >= n: break
        return res