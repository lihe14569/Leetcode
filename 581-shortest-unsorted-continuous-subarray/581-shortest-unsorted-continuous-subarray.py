class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        snums = sorted(nums)
        n = len(nums)
        l, r = n, 0
        for i in range(n):
            if nums[i] != snums[i]:
                l = min(l, i)
                r = max(r, i)
        return r - l + 1 if r - l + 1 > 0 else 0