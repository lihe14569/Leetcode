class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        total, max_num = 0, nums[0]
        for num in nums:
            max_num = max(max_num, num)
            total += num
        l, r=  max_num, total
        
        def countSubarray(nums, num_sum):
            cnt,  curr_sum= 1, 0
            for num in nums:
                if curr_sum + num <= num_sum:
                    curr_sum += num
                else:
                    cnt += 1
                    curr_sum = num
            return cnt
        
        while l < r:
            mid = (l + r) // 2
            if countSubarray(nums, mid) <= m:
                r = mid
            else:
                l = mid + 1
        return l