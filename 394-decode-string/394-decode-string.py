class Solution:
    def decodeString(self, s: str) -> str:
        stack = []; currNum = 0; currStr = ''
        for c in s:
            if c == '[':
                stack.append(currNum)
                stack.append(currStr)
                currNum = 0
                currStr = ''
            elif c == ']':
                prevStr = stack.pop()
                num = stack.pop()
                currStr = prevStr + num*currStr
            elif c.isdigit():
                currNum = currNum * 10 + int(c)
            else:
                currStr += c
        return currStr