class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        def get_final(s):
            res = ''
            for c in s:
                if c != '#':
                    res += c
                else:
                    res = res[:-1]
            return res
        return get_final(s) == get_final(t)