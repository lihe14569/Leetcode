class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        prefix = [0]* (len(nums) + 1)
        for i in range(len(nums)):
            prefix[i + 1] = prefix[i] + nums[i]
        
        queue = deque()
        res = len(nums) + 1
        for i in range(len(nums) + 1):
            while queue and prefix[i] - prefix[queue[0]] >= k:
                res = min(res, i - queue[0])
                queue.popleft()
            while queue and prefix[i] <= prefix[queue[-1]]:
                queue.pop()
            queue.append(i)
        return res if res != len(nums) + 1 else -1