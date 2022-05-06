class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n, cnt= len(grid), len(grid[0]), 0
        dsu = DSU(m*n)
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    grid[i][j] = '0'
                    cnt += 1
                    for x, y in [(i + 1, j), (i -1, j), (i, j + 1), (i, j - 1)]:
                        if 0 <= x < m and 0 <= y < n and grid[x][y] == '1':
                            if dsu.find(i*n + j) != dsu.find(x*n + y):
                                dsu.union(i*n + j, x*n + y)
                                cnt -= 1
        return cnt

class DSU:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        self.parent[self.find(x)] = self.parent[y]