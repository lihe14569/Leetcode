class Solution:
    #abbca
    #01234
    #134
    def appealSum(self, s: str) -> int:
        res, curr, prev = 0, 0, {}
        for i, ch in enumerate(s):
            curr += i - (prev[ch] if ch in prev else -1)
            prev[ch] = i
            res += curr
        return res