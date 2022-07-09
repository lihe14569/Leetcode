class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res = [0] * (n - k + 1)
        q = deque()
        
        for i in range(n):
            idx = i - k + 1
            while q and i - q[0] + 1 > k:
                q.popleft()
            while q and nums[i] >= nums[q[-1]]:
                q.pop()
            q.append(i)
            if idx >= 0:
                res[idx] = nums[q[0]]
        return res