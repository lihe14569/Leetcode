class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = 0
        n = len(nums) + 1
        i = 1
        for num in nums:
            res ^= num ^ i
            i += 1
        
        return res