import bisect
class Solution:
    def maxEnvelopes(self, nums: List[List[int]]) -> int:
        nums.sort(key=lambda x: (x[0], -x[1]))
        n = len(nums)
        sub = []
        for i in range(n):
            j = bisect.bisect_left(sub, nums[i][1])
            if j == len(sub):
                sub.append(nums[i][1])
            else:
                sub[j] = nums[i][1]
        return len(sub)