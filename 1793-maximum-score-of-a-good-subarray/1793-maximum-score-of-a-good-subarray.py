class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        res, n = nums[k], len(nums)
        stack = [-1]
        
        for i in range(n):
            while stack[-1] != -1 and nums[i] <= nums[stack[-1]]:
                height = nums[stack.pop()]
                width = i - stack[-1] - 1
                if stack[-1] < k < i:
                    res = max(res, height*width)
            stack.append(i)
        while stack[-1] != -1:
            height = nums[stack.pop()]
            width = n - stack[-1] - 1
            if stack[-1] < k < n:
                res = max(res, height* width)
        return res
                
        