import bisect
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        sub, n = [], len(nums)
        for i in range(n):
            j = bisect.bisect_left(sub, nums[i])
            if j == len(sub):
                sub.append(nums[i])
            else:
                sub[j] = nums[i]
        return len(sub)
                