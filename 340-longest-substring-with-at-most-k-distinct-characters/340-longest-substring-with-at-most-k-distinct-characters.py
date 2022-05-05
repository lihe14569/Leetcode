class Solution:
     def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        if k == 0: return 0
        i, max_len, index_map = 0, 0, collections.OrderedDict()
        for j, c in enumerate(s):
            index_map[c] = j
            index_map.move_to_end(c)
            if len(index_map) > k:
                _, i = index_map.popitem(last=False)
                i += 1
            max_len = max(max_len, j - i + 1)
        return max_len