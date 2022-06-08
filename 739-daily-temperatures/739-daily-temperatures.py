class Solution:
    def dailyTemperatures(self, temp: List[int]) -> List[int]:
        res = [0]*len(temp)
        stack = []
        for i in range(len(temp) -1, - 1, -1):
            while stack and temp[i] >= temp[stack[-1]]:
                stack.pop()
            res[i] = stack[-1] - i if stack else 0
            stack.append(i)
        return res