class Solution:
    def countSubstrings(self, s: str) -> int:
        n, res = len(s), 0
        dp = [[False]*len(s) for _ in range(n)]
        
        for i in range(n -1, -1, -1):
            for j in range(i, n):
                dp[i][j] = s[i] == s[j] and (j - i + 1 <=2 or dp[i + 1][j - 1])
                if dp[i][j]:
                    res += 1
        return res