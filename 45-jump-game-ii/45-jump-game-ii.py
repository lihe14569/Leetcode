class Solution:
    def jump(self, nums: List[int]) -> int:
        dp = [0] * len(nums)
        j = 0
        for i in range(1, len(nums)):
            while j + nums[j] < i:
                j += 1
            dp[i] = dp[j] + 1
        return dp[len(nums) - 1]