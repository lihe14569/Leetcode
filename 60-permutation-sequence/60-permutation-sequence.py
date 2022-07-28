class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        res = ''
        seen =[False] * (n + 1)
        
        for i in range(n):
            fact = 1
            for j in range(1, n - i):
                fact *= j
            
            for j in range(1, n + 1):
                if not seen[j]:
                    if fact < k: k -= fact
                    else:
                        res += str(j)
                        seen[j] = True
                        break
        return res