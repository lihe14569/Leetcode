class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        visited = set()
        def dfs(lst, visited):
            nonlocal res
            if len(lst) == len(nums):
                res.append(lst[:])
                return
            
            for i in range(len(nums)):
                
                if i in visited or (i != 0 and nums[i] == nums[i - 1] and i - 1 in visited):
                    continue
                lst.append(nums[i])
                visited.add(i)
                dfs(lst,visited)
                lst.pop()
                visited.remove(i)
        dfs([], visited)
        return res
            