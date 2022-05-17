class Solution:
    def amountPainted(self, paint: List[List[int]]) -> List[int]:
        line, res = [0] * 50001, [0] * len(paint)
        for i, (start, end) in enumerate(paint):
            while start < end:
                jump = max(start + 1, line[start])
                res[i] += 1 if line[start] == 0 else 0
                line[start] = max(line[start], end)  # compression
                start = jump
        return res
            