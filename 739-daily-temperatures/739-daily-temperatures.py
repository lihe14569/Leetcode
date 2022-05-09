class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        res = [0] * len(t)
        stack = []
        for i in range(len(t)):
            curr = t[i]
            while stack and t[i] > t[stack[-1]]:
                prevIdx = stack.pop()
                res[prevIdx] = i - prevIdx
            stack.append(i)
        return res