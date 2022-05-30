class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        m, n = map(len, (grid, grid[0]))
        dis = [[inf]*n for _ in range(m)]
        dis[0][0] = 0
        hq = [[dis[0][0], 0 , 0]]
        
        while hq:
            curr_dis, r, c = heapq.heappop(hq)
            if r == m - 1 and c == n - 1:
                return curr_dis
            for i, j in (r + 1, c), (r - 1, c), (r, c + 1), (r, c - 1):
                if 0 <= i < m and 0 <= j < n and curr_dis + grid[i][j] < dis[i][j]:
                    dis[i][j] = curr_dis + grid[i][j]
                    heapq.heappush(hq, [dis[i][j], i , j])
                