class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        l, r = 0, 0
        for num in nums:
            l = max(l, num)
            r += num
        
        def countArr(nums, mid):
            cnt, total = 1, 0
            for num in nums:
                if total + num <= mid:
                    total += num
                else:
                    cnt += 1
                    total = num
            return cnt
        while l < r:
            mid = (l + r) // 2
            if countArr(nums, mid) <= m:
                r = mid
            else:
                l  = mid + 1
        return l