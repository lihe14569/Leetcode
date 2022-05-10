class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = [0] * (len(nums) - k + 1)
        q = deque()
        for i in range(len(nums)):
            idx = i - k + 1
            #maintain k length window
            while q and i - q[0] + 1 > k:
                q.popleft()
            #maitain queue ascending 
            while q and nums[i] >= nums[q[-1]]:
                q.pop()
            q.append(i)
            if idx >= 0:
                res[idx] = nums[q[0]]
        return res