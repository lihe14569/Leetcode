class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = [0] * (len(nums) - k + 1)
        queue = deque()
        
        for i in range(len(nums)):
            idx = i - k + 1
            while queue and  i - queue[0]  + 1 > k:
                queue.popleft()
            while queue and nums[i] >= nums[queue[-1]]:
                queue.pop()
            queue.append(i)
            if idx >= 0:
                res[idx] = nums[queue[0]]
        return res