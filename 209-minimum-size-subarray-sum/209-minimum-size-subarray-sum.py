class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l, n, res, csum = 0, len(nums), float('inf'), 0
        for i in range(n):
            csum += nums[i]
            while csum >= target:
                res = min(res, i - l + 1)
                csum -= nums[l]
                l += 1
        return 0 if res == float('inf') else res
                