class Solution:
    def dailyTemperatures(self, t: List[int]) -> List[int]:
        #正向单调栈
        res = [0] * len(t)
        stack = deque()
        #维持一个单调递减栈
        for i in range(len(t)):
            while stack and t[stack[-1]] < t[i]:
                idx = stack.pop()
                res[idx] = i - idx
            stack.append(i)
        return res
        