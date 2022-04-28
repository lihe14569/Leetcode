class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        dic = defaultdict(int)
        l, n, res = 0, len(s), 0
        
        for i in range(0, n):
            c1 = s[i]
            dic[c1] += 1
            if len(dic) > 2:
                c2 = s[l]
                dic[c2] -= 1
                if dic[c2] == 0: 
                    dic.pop(c2)
                l += 1
            res = max(res, i - l  + 1)
        return res
                    