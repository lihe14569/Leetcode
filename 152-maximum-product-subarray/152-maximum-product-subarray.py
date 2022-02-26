class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        #dp
        maxP = minP = nums[0]
        result = maxP
        for num in nums[1:]:
            tempMax = max(num, maxP * num, minP * num)
            minP = min(num, maxP * num, minP * num)
            maxP = tempMax
            result = max(result, maxP)
        return result