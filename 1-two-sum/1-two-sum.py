class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(nums)):
            if target - nums[i] in map:
                return [i, map[target - nums[i]]]
            map[nums[i]] = i
        return [-1, - 1]