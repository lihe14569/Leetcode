class Solution:
    def maxArea(self, height: List[int]) -> int:
        l, r = 0, len(height) - 1
        area = 0
        while l < r:
            minHeight = min(height[l], height[r])
            width = r - l
            area = max(area, width * minHeight)
            if height[l] <= height[r]:
                 l+= 1
            else:
                r -= 1
        return area