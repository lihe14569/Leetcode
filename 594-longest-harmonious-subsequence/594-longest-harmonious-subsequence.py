class Solution:
    def findLHS(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        res = 0
        for num in cnt.keys():
            if num + 1 in cnt:
               res = max(res, cnt[num + 1] + cnt[num])
        return res