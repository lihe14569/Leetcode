class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n, left, res = len(s), 0, 0
        dic = {}
        
        for i in range(n):
            c = s[i]
            while c in dic.keys():
                del dic[s[left]]
                left += 1
            dic[c] = i 
            
            res = max(res, i - left + 1)
        return res