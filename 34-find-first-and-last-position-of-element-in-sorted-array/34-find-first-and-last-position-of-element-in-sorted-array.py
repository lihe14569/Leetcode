class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1, -1]
        if not nums: return res
        l, r=  0, len(nums) -1
        while l < r:
            m = (l + r) // 2
            if nums[m] >= target:
                r = m
            else:
                l = m + 1
        if nums[l] != target:
            return [-1, -1]
        res[0] = l
        r = len(nums) - 1
        while l < r:
            m = (l + r + 1) // 2
            if nums[m] <= target:
                l = m
            else:
                r = m - 1
        res[1] = l
        return res