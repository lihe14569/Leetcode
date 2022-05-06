class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        #union-find
        m, n, cnt= len(grid), len(grid[0]), 0
        dsu = DSU(m*n)
        
        for r in range(m):
            for c in range(n):
                if grid[r][c] == '1':
                    cnt += 1
                    grid[r][c] == '0'
                    for x, y in [(r + 1, c), (r -1,c), (r, c +1), (r, c - 1)]:
                        if 0<=x< m and 0<= y < n and grid[x][y] == '1':
                            if(dsu.find(r*n + c) != dsu.find(x*n + y)):
                                cnt -= 1
                            dsu.union(r*n + c, x*n + y)
        return cnt

class DSU:
    def __init__(self, n):
        self.count = 0
        self.parent = [i for i in range(n)]
        
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        self.parent[self.find(x)] = self.parent[y]
