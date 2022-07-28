class Solution:
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        if grid[0][0] == 1: return 0
        
        dp[0][0] = 1
        for i in range(m):
            for j in range(n):
                if grid[i][j] != 1:
                    if i == j == 0: continue
                    elif i == 0 or j == 0:
                        if not i: dp[i][j] = dp[i][j - 1]
                        if not j: dp[i][j] = dp[i - 1][j]
                    else:
                        dp[i][j] += dp[i- 1][j] + dp[i][j - 1]
        return dp[-1][-1]
                    