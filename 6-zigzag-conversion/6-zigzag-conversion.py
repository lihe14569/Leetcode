class Solution:
    def convert(self, s: str, numRows: int) -> str:
        res = ""
        if len(s) == 1 or numRows == 1: return s
        for i in range(numRows):
            if i == 0  or i == numRows - 1:
                for j in range(i, len(s), 2*(numRows) - 2):
                    res += s[j]
            else:
                j , k = i, 2 *(numRows) - 2 - i
                while j < len(s) or k < len(s):
                    res += s[j]
                    j += 2*(numRows) - 2
                    if k < len(s):
                        res += s[k]
                        k += 2 * numRows - 2
        return res