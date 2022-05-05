class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #two pointer
        left, n = 0, len(nums)
        
        for i in range(n):
            if nums[i] != 0:
                nums[left], nums[i] = nums[i], nums[left]
                left += 1
        return nums
        