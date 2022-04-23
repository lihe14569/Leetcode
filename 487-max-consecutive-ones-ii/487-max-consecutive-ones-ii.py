class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        #sliding window
        n, left, res, cnt = len(nums), 0, 0, 0
        
        for i in range(n):
            if nums[i] == 0:
                cnt += 1
            while cnt > 1:
                if nums[left] == 0:
                    cnt -= 1
                left += 1
            res = max(res, i - left + 1)
        return res