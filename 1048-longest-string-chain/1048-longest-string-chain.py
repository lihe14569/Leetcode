class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        dp = {}
        res = 1
        for w in sorted(words, key=len):
            dp[w] = 1
            for i in range(len(w)):
                pre = w[:i] + w[i+1:]
                if pre in dp:
                    dp[w] = max(dp[pre] + 1, dp[w])
                    res = max(res, dp[w])
        return res