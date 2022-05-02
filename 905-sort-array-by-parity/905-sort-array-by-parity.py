class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        l, n = 0, len(nums)
        for i in range(n):
            if nums[i] % 2 == 0:
                nums[l], nums[i] = nums[i], nums[l]
                l += 1
        return nums