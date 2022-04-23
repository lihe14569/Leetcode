class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        one, zero, res = 0, 1, 0
        
        for i in range(len(nums)):
            if nums[i] == 0:
                one = zero
                zero = 1
            else:
                one += 1
                zero += 1
            res = max(res, one)
            
        return res
    #i , zero , one, res
    #     1      0    0
    #0    2      1    2
    #1    1      2    2
    #2    2      3    3
    #3    3      4    4
    #4    1      3    3