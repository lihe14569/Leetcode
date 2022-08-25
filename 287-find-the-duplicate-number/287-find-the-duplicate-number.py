class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        nums.sort()
        prev = nums[0]
        for i in range(1, len(nums)):
            if(nums[i] == prev):
                return nums[i]
            else:
                prev = nums[i]
        return -1