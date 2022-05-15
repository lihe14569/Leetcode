class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        def dfs(r, c, d):
            if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or grid[r][c] == 0:
                return
            path.append(d)
            grid[r][c] = 0
            dfs(r + 1, c, 'D')
            dfs(r - 1, c, 'U')
            dfs(r, c + 1, 'R')
            dfs(r, c - 1, 'L')
            path.append('0')
        islands = set()
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] != 0:
                    path = []
                    dfs(i, j, '0')
                    if path:
                        islands.add(tuple(path))
        return len(islands)
            
            
            