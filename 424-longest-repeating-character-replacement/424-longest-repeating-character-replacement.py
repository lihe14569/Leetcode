class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, n , res, freq = 0, len(s), 0, 0
        dic = defaultdict(int)
        for i in range(n):
            dic[s[i]] += 1
            freq = max(freq, dic[s[i]])
            while i - l + 1 - freq > k:
                c2 = s[l]
                dic[c2] -= 1
                l += 1
            res = max(res, i - l + 1)
        return res