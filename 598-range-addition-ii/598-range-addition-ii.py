class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        min_r, min_c = m , n
        for r, c in ops:
            min_r = min(min_r, r)
            min_c = min(min_c, c)
        return min_r*min_c