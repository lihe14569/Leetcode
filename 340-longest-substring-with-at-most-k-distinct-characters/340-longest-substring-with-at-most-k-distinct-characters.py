class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if k == 0: return 0
        left, maxLen, dic = 0, 0, collections.OrderedDict()
        
        for i, c in enumerate(s):
            dic[c] = i
            dic.move_to_end(c)
            while len(dic) > k:
                _, left = dic.popitem(last=False)
                left += 1
            maxLen = max(maxLen, i -left + 1)
        return maxLen