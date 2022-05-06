class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #dfs
        res,m , n = 0, len(grid), len(grid[0])
        def dfs(grid, i , j):
            grid[i][j] = '0'
            for (x, y) in [(i + 1, j), (i -1, j), (i, j + 1), (i, j - 1)]:
                if x >= 0 and x < m and y >= 0 and y < n and grid[x][y] == '1':
                    dfs(grid, x, y)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(grid, i, j)
                    res += 1
        return res