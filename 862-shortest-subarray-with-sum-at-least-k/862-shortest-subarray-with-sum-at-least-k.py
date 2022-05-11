class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n = len(nums)
        monoq = deque()
        res = n + 1
        prefix = [0] * (n + 1)
        for i in range(n): prefix[i + 1] = prefix[i] + nums[i]
        
        for i in range(n + 1):
            while monoq and prefix[i] - prefix[monoq[0]] >= k:
                res = min(res, i - monoq.popleft())
            while monoq and prefix[i] <= prefix[monoq[-1]]:
                monoq.pop()
            monoq.append(i)
        return res if res != n + 1 else -1
            