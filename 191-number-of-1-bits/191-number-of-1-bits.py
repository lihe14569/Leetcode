class Solution:
    def hammingWeight(self, n: int) -> int:
        cnt = 0
        move = 32
        while move:
            if n & 1 == 1:
                cnt += 1
            n >>= 1
            move -= 1
        return cnt
            