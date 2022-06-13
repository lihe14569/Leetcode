class Solution:
    def minPathCost(self, grid: List[List[int]], moveCost: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[sys.maxsize]*n for _ in range(m)]
        
        for i in range(n): dp[0][i] = grid[0][i]
        
        for i in range(1, m):
            for j in range(n):
                for k in range(n):
                    dp[i][j] = min(dp[i][j], dp[i -1][k] + moveCost[grid[i- 1][k]][j] + grid[i][j])
        
        return min(dp[-1])