class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #bfs 
        res, m, n = 0, len(grid), len(grid[0])
        def bfs(grid, i, j):
            grid[i][j] = 'x'
            q = deque([(i, j)])
            while q:
                size = len(q)
                for k in range(size):
                    i, j = q.popleft()
                    for nx, ny in [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]:
                        if nx >= 0 and nx < m and ny >= 0 and ny < n and grid[nx][ny] == '1':
                            q.append((nx, ny))
                            grid[nx][ny] = 'x'
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    bfs(grid, i, j)
                    res += 1
        return res