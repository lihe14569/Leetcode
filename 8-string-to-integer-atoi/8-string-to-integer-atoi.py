class Solution:
    def myAtoi(self, s: str) -> int:
        i = 0
        res = 0
        lower, upper = -2**31, 2**31 - 1
        while i < len(s) and s[i] == ' ': 
            i += 1
        neg = 1
        if i < len(s) and s[i] == '-':
            neg = -1
            i += 1
        elif i < len(s) and s[i] == '+':
            neg = 1
            i += 1
        while i < len(s) and s[i] in "0123456789":
            if neg == 1 and res > (upper - (ord(s[i]) - ord('0'))) / 10:
                return upper
            if neg == - 1 and res > (upper - (ord(s[i]) - ord('0')) + 1) / 10:
                return lower
            res = res * 10 + (ord(s[i]) - ord('0'))
            i += 1
        return res * neg
        