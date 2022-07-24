class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        res = 0
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                curr = stack.pop()
                if not stack: break
                wall = min(height[i], height[stack[-1]])
                res += (wall - height[curr]) * (i - stack[-1] - 1)
            stack.append(i)
        return res