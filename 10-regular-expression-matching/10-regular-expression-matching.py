class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        dp = [[False]*(n + 1) for _ in range(m + 1)]
        
        s= ' '+ s
        p = ' ' + p
        dp[0][0] = True
        
        for i in range(m + 1):
            for j in range(1, n + 1):
                #特判
                if j + 1 <= n and p[j + 1] == '*':
                    continue
                if p[j] != '*':
                    if dp[i - 1][j - 1] and (s[i] == p[j] or p[j] == '.'):
                        dp[i][j] = True
                else:
                    dp[i][j] = dp[i][j - 2] or (i and dp[i -1][j] and (s[i] == p[j - 1] or p[j - 1] == '.'))
        return dp[m][n]