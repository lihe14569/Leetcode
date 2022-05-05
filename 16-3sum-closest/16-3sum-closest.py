class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        res = nums[0]+ nums[1] + nums[-1]
        nums.sort()
        
        for i in range(len(nums)):
            l, r = i + 1, len(nums) - 1
            while l < r:
                curr_sum = nums[i] + nums[l] + nums[r]
                if abs(target - curr_sum) < abs(target - res):
                    res = curr_sum
                if curr_sum > target:
                    r -= 1
                else:
                    l += 1
        return res