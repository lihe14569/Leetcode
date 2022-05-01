class Solution:
    def findPermutation(self, s: str) -> List[int]:
        n, res, stack= len(s), [], []
        for i in range(n):
            if s[i] == 'I':
                stack.append(i + 1)
                while stack:
                    res.append(stack.pop())
            else:
                stack.append(i + 1)
        stack.append(n + 1)
        while stack:
            res.append(stack.pop())
        return res