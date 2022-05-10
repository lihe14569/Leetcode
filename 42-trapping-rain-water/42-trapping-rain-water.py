class Solution:
    def trap(self, height: List[int]) -> int:
        res = 0
        stack = []
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                low_height = height[stack.pop()]
                if not stack: break
                high_height = min(height[i], height[stack[-1]])
                res += (i - stack[-1] - 1)*(high_height - low_height)
            stack.append(i)
        return res