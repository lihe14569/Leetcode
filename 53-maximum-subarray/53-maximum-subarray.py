class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        total_max, curr_max = float('-inf'), float('-inf')
        for num in nums:
            curr_max = max(curr_max + num, num)
            total_max = max(total_max, curr_max)
        return total_max