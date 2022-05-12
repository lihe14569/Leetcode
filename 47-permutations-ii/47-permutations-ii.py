class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        def backtrack(lst, counter):
            if len(lst) == len(nums):
                res.append(lst[:])
                return
            for num in counter:
                if counter[num] > 0:
                    lst.append(num)
                    counter[num] -= 1
                    backtrack(lst, counter)
                    lst.pop()
                    counter[num] +=1
        backtrack([], Counter(nums))
        return res