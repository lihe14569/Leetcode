class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        lst = []
        seen = set()
        nums.sort()
        def dfs():
            if len(lst) == len(nums):
                res.append(lst[:])
                return
            for i in range(len(nums)):
                if i in seen or (i != 0 and nums[i] == nums[i - 1] and i - 1 not in seen):
                    continue
                seen.add(i)
                lst.append(nums[i])
                dfs()
                seen.remove(i)
                lst.pop(-1)
        dfs()
        return res