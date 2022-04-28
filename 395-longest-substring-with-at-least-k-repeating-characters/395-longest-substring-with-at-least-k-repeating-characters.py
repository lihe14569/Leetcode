class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        res = 0
        for i in range(1, 27):
            l, n, cnt = 0, len(s), 0
            dic = defaultdict(int)
            for j in range(n):
                c1 = s[j]
                dic[c1] += 1
                if dic[c1] == k:
                    cnt += 1
                while len(dic) > i:
                    c2 = s[l]
                    if dic[c2] == k:
                        cnt -= 1
                    dic[c2] -= 1
                    if dic[c2] == 0:
                        dic.pop(c2)
                    l += 1
                valid_cnt = len(dic)
                if valid_cnt == cnt and valid_cnt == i:
                    res = max(res, j - l + 1)
        return res
                    
                    
            