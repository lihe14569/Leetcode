class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        sArr = sorted(nums)
        l, r = 0, len(nums) - 1
        while l < len(nums):
            if nums[l] != sArr[l]:
                break
            else: l+= 1
        while r >= 0:
            if nums[r] != sArr[r]:
                break
            else: r -= 1
        return r - l + 1 if r - l + 1 > 0 else 0