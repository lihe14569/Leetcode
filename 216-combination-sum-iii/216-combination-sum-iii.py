class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []
        def dfs(curr, lst, target):
            nonlocal res
            #base case
            if len(lst) == k and target == 0:
                res.append(lst[:])
                return
            for i in range(curr, 10):
                if i in lst: continue
                lst.append(i)
                dfs(i + 1, lst, target - i)
                lst.pop()
        dfs(1, [], n)
        return res
            