class Solution:
   def hasValidPath(self, A):
        m, n = len(A), len(A[0])
        # if (n + m) % 2 == 0: return False
        dp = [[set() for j in range(n)] for i in range(m)]
        for i in range(m):
            for j in range(n):
                d = 1 if A[i][j] == '(' else -1
                for a in dp[i-1][j] if i else []: 
                    if a + d >= 0:
                        dp[i][j].add(a+d)                
                for a in dp[i][j-1] if j else []:
                    if a + d >= 0:
                        dp[i][j].add(a+d)
                if i == 0 and j == 0:
                    if d >= 0:
                        dp[i][j].add(d)
        return 0 in dp[-1][-1]