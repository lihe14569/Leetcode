class Solution:
    def trap(self, height: List[int]) -> int:
        res, stack = 0, []
        
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                l = stack.pop()
                if not stack:
                    break
                h = min(height[i], height[stack[-1]])
                res += (i - stack[-1] - 1) * (h - height[l])
            stack.append(i)
        return res