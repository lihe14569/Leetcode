class Solution:
    def reverse(self, x: int) -> int:
        neg = 1
        if x < 0: neg = -1
        res = 0
        lower, upper = -2**31, 2**31 - 1
        x = abs(x)
        while x != 0:
            if neg == 1 and res > (upper - x % 10) / 10:
                return 0
            if neg == -1 and res > (upper - x % 10 + 1) / 10:
                return 0
            
            res = res * 10 + x % 10
            x //= 10
        return res * neg
            
        