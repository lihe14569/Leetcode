class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        dic = defaultdict(int)
        l, n, res = 0, len(s), 0
        
        for i in range(n):
            c1 = s[i]
            dic[c1] += 1
            while len(dic) > k:
                c2 = s[l]
                dic[c2] -= 1
                l += 1
                if dic[c2] == 0:
                    dic.pop(c2)
            res = max(res, i - l + 1)
        return res