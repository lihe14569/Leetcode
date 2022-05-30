class Solution:
    def totalSteps(self, nums: List[int]) -> int:
        res=0
        stack = []
        dp = [0] * len(nums)
        for i in range(len(nums)):
            curr = 0
            while stack and nums[i] >= nums[stack[-1]]:
                curr = max(curr, dp[stack.pop()])
            if stack:
                dp[i] = curr + 1
            stack.append(i)
        return max(dp)