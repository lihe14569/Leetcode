class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l, cnt, n = 1, 1, len(nums)
        for i in range(1, n):
            if nums[i] != nums[i - 1]:
                nums[l] = nums[i]
                l += 1
        return l
            