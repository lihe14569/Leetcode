stack.append(i)
return res
```
​
逆序 单调递减栈
```
def dailyTemperatures(self, t: List[int]) -> List[int]:
res = [0] * len(t)
stack = []
for i in range(len(t) - 1, -1, -1):
while stack and t[i] >= t[stack[-1]]: stack.pop()
res[i] = stack[-1] - i if stack else 0
stack.append(i)
return res
```
​
逆序和顺序：
逆序： stack中存右边界（下一个大温度的index）
```
def dailyTemperatures(self, temp: List[int]) -> List[int]:
res = [0]*len(temp)
stack = []
for i in range(len(temp) -1, - 1, -1):
while stack and temp[i] >= temp[stack[-1]]:
stack.pop()
res[i] = stack[-1] - i if stack else 0
stack.append(i)
return res
```
​
顺序：(stack中存的是单调递减的天数的index,如果遇到当前i天比stack末尾天温度高，当前天就是下一个高温度的天)
```
​
```
​