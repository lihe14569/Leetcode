class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [ [0]*(n + 1)for j in range(m + 1) ]
        for s in strs:
            dic = Counter(s)
            for i in range(m, dic['0'] -1, -1):
                for j in range(n, dic['1'] - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - dic['0']][j - dic['1']] + 1)
        return dp[m][n]