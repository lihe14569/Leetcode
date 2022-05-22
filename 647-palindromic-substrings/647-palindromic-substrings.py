class Solution:
    def countSubstrings(self, s: str) -> int:
        dp = [[False]*len(s) for i in range(len(s))]
        
        n = len(s)
        res = 0
        for i in range(n - 1, - 1, -1):
            for j in range(i, n):
                if i == j:
                    dp[i][j] = True
                    res += 1
                elif i + 1 <= n - 1 and i + 1 == j and s[i] == s[j]:
                    dp[i][j] = True
                    res += 1
                elif s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1]
                    if dp[i][j]:
                        res += 1
        return res
                
                