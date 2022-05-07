class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res=[]
        def backtrack(i: int, lst: List[int]):
            nonlocal res
            res.append(lst[:])
            for idx in range(i,len(nums)):
                lst.append(nums[idx])
                backtrack(idx + 1, lst)
                lst.pop()
        backtrack(0,[])
        return res
                