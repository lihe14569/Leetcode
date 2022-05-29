class Solution:
    
#         stack = []
#         #单调递增
#         res = 0
#         n = len(nums)
#         for i in range(n):
#             while stack and nums[i] >= nums[stack[-1]]:
                
#                 last = stack.pop()
#                 while stack and nums[last] < 
#                 res = max(res, i - stack.pop() - 1)
#             stack.append(i)
#         stack = []
#         for i in range(n-1, -1, -1):
#             while stack and nums[i] > nums[stack[-1]]:
#                 res = max(res, stack.pop() - i)
#             stack.append(i)
#         return res

    def totalSteps(self, nums: List[int]) -> int:
        res,stack = 0, []
        for i in range(len(nums)-1,-1,-1):
            cur = 0
            while stack and nums[stack[-1][0]]<nums[i]:
                _,v = stack.pop()
                cur=max(cur+1,v)
            res = max(res,cur)
            stack.append([i,cur])
        return res
            
                
            