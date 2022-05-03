class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = collections.deque()
        for s in tokens:
            if s not in '+-*/':
                stack.append(int(s))
            else:
                val1,val2 = stack.pop(), stack.pop()
                if s == '+':
                    stack.append(val2 +val1)
                elif s == '-':
                    stack.append(val2 - val1)
                elif s == '*':
                    stack.append(val1 * val2)
                else:
                    stack.append(int(float(val2) / val1))
        return stack.pop()
        