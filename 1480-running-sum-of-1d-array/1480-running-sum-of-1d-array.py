class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        ps = [0] * (len(nums)  + 1)
        for i in range(len(nums)):
            ps[i + 1] = nums[i] + ps[i]
        return ps[1:]