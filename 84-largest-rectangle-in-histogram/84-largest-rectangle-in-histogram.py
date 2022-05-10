class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        res = 0
        stack = []
        stack.append(-1)
        n = len(heights)
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[i] < heights[stack[-1]]:
                l = stack.pop()
                res = max(res, (i - stack[-1] - 1) * heights[l])
                
            stack.append(i)
        while stack[-1] != -1:
            l = stack.pop()
            res = max(res, (n - stack[-1] - 1) * (heights[l]))
            
            
        return res
            