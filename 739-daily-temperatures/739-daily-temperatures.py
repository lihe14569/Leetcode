class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        res = [0] * len(t)
        stack = []
        for i in range(len(t) - 1, -1, -1):
            while stack and t[i] >= t[stack[-1]]: stack.pop()
            res[i] = stack[-1] - i if stack else 0
            stack.append(i)
        return res