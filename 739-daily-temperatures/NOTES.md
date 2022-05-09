单调递减栈-》遍历书序：从左到右
```
def dailyTemperatures(self, t: List[int]) -> List[int]:
#正向单调栈
res = [0] * len(t)
stack = deque()
#维持一个单调递减栈
for i in range(len(t)):
curr_t = t[i]
while len(stack) != 0 and t[stack[-1]] < curr_t:
idx = stack.pop()
res[idx] = i - idx
stack.append(i)
return res
```
using list as stack
```
def dailyTemperatures(self, t: List[int]) -> List[int]:
res = [0] * len(t)
stack = []
for i in range(len(t)):
while stack and t[i] > t[stack[-1]]:
prevIdx = stack.pop()
res[prevIdx] = i - prevIdx
stack.append(i)
return res
```
​