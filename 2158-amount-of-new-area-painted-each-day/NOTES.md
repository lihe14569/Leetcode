方法一： line jump
```
def amountPainted(self, paint: List[List[int]]) -> List[int]:
res, area = len(paint)*[0], [0]* 50001
for i, (start, end) in enumerate(paint):
while start < end:
next_start = max(start+ 1, area[start])
res[i] += 1 if area[start] == 0 else 0
area[start] = max(area[start], end)
start = next_start
return res
```
方法二：