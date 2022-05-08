class Solution:
    def countTexts(self, s: str) -> int:
        n = len(s)
        dp = [0] * (n + 1)
        dp[0]= 1
        for i in range(1, n + 1):
            dp[i] = dp[i -1]
            if i - 2 >= 0 and s[i - 1] == s[i -2]:
                dp[i] += dp[i -2]
            if i - 3 >= 0 and s[i - 1] == s[i - 2] and s[i - 1] == s[i - 3]:
                dp[i] += dp[i -3]
            
            if s[i - 1] in '79' and i - 4 >= 0 and  s[i - 1] == s[i - 2] and s[i - 1] == s[i - 3] and s[i - 1] == s[i-4]:
                dp[i] += dp[i - 4]
            dp[i] %= (10**9 + 7)
        return dp[-1] %(10**9 + 7)
                