class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        res = min_num = nums[k]
        l , r, n = k, k, len(nums)
        
        while l > 0 or r < n - 1:
            left = nums[l - 1] if l - 1 >= 0 else 0
            right = nums[r + 1] if r + 1 < n else 0
            if left < right:
                r += 1
            else:
                l -= 1
            min_num = min(min_num, nums[l], nums[r])
            res = max(res, min_num * (r - l + 1))
        return res