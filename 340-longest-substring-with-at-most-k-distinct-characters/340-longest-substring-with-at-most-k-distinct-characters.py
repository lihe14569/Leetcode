class Solution:
     def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        i, max_len, index_map = 0, 0, collections.OrderedDict()
        for j, c in enumerate(s, 1):
            index_map[c] = j
            index_map.move_to_end(c)
            if len(index_map) > k:
                _, i = index_map.popitem(last=False)
            max_len = max(max_len, j - i)
        return max_len