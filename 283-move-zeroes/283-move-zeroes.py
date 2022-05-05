class Solution:
    
    def moveZeroes(self, nums: List[int]) -> None:
        l , n = 0, len(nums)
        
        for i in range(n):
            if nums[i] != 0:
                nums[l], nums[i] = nums[i], nums[l]
                l += 1
        
        
        