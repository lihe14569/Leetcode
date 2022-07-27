class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        for i in range(1,n):
            if dp[i - 1] < i: return False
            ###动态转换 不太好理解
            dp[i] = max(dp[i - 1], nums[i] + i)
            if dp[i] >= n - 1: return True
        return True if dp[n - 1] >= n - 1 else False