class Solution:
    def subStrHash(self, s: str, power: int, modulo: int, k: int, hashValue: int) -> str:
        n = len(s)
        weight = 1
        for i in range(k -1):
            weight = (weight * power) % modulo
        hash = 0
        r = n - 1
        res = ''
        for i in range(n - 1, -1, -1):
            curr = ord(s[i]) - ord('a') + 1
            hash = (hash*power%modulo + curr) % modulo
            if r - i + 1 == k:
                if hash == hashValue:
                    res = s[i:r+1]
                hash = (hash + modulo - (ord(s[r]) - ord('a') + 1)*weight%modulo) % modulo
                r -= 1
        return res
            