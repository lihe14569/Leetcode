class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        n, num_k = len(nums), float('-inf')
        stack = collections.deque([nums[n -1]])
        for i in range(n - 2, -1, -1):
            if nums[i] < num_k:
                return True
            while stack and stack[-1] < nums[i]:
                num_k = max(num_k, stack[-1])
                stack.pop()
            if nums[i] > num_k:
                stack.append(nums[i])
        return False 