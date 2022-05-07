class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        def dfs(idx: int, lst: List[int]):
            nonlocal res
            res.append(lst[:])
            for i in range(idx, len(nums)):
                lst.append(nums[i])
                dfs(i + 1, lst)
                lst.pop()
            
        dfs(0, [])
        return res