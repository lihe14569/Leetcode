class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        MIN_INT = -2**31
        MAX_INT = 2**31 - 1
        print(MIN_INT)
        print(MAX_INT)
        if dividend == MIN_INT and divisor == -1:
            return MAX_INT
        
        negative = (dividend < 0 and divisor > 0) or (dividend > 0 and divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        shift, res = 31, 0
        
        while dividend >= divisor:
            while dividend < (divisor << shift):
                shift -= 1
            dividend -= divisor << shift
            res += 1 << shift
        return res if not negative else -res