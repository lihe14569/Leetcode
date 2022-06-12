class Solution:
    def countSubarrays(self, A: List[int], k: int) -> int:
        n = len(A)
        res = 0
        acc = list(accumulate(A, initial = 0))
        l = 0
        for i in range(n):
            while (acc[i + 1] - acc[l])*(i - l + 1) >= k:
                l += 1
            res += i - l + 1
        return res