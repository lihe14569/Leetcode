class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        def dfs(idx:int, lst:List[int]):
            res.append(lst[:])
            for i in range(idx, len(nums)):
                if i != idx and nums[i] == nums[i - 1]:
                    continue
                lst.append(nums[i])
                dfs(i + 1, lst)
                lst.pop()
        dfs(0, [])
        return res 
                