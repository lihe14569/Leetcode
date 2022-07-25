class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        lst = []
        seen = set()
        def dfs():
            nonlocal res, lst, seen
            if len(lst) == len(nums):
                res.append(lst[:])
                return
            for i in range(len(nums)):
                if nums[i] in seen:
                    continue
                seen.add(nums[i])
                lst.append(nums[i])
                dfs()
                seen.remove(nums[i])
                lst.pop(-1)
        dfs()
        return res
                