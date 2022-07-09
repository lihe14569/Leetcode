class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums)
        score = [0] * n
        score[0] = nums[0]
        q = deque()
        q.append(0)
        for i in range(1, n):
            while q and q[0] < i - k:
                q.popleft()
            score[i] = score[q[0]] + nums[i]
            while q and score[i] >= score[q[-1]]:
                q.pop()
            q.append(i)
        return score[-1]