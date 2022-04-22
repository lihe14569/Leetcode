class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n, left, res = len(s), 0, 0
        dic = {}
        
        for i in range(n):
            c = s[i]
            if c in dic.keys():
                left = max(dic[c], left)
            dic[c] = i + 1
            res = max(res, i - left + 1)
        return res