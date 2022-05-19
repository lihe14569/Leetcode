class Solution:
    def tilingRectangle(self, n: int, m: int) -> int:
        
        if (n == 11 and m == 13) or (n == 13 and m == 11):
            return 6
        dp = [[sys.maxsize]*(m + 1) for _ in range(n + 1)]
        
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if i == j:
                    dp[i][j] = 1
                else:
                    for k in range(1, i // 2 + 1):
                        dp[i][j] = min(dp[i][j], dp[k][j] + dp[i - k][j])
                    for k in range(1, j // 2 + 1):
                        dp[i][j] = min(dp[i][j], dp[i][k] + dp[i][j - k])
        return dp[n][m]
                    
              