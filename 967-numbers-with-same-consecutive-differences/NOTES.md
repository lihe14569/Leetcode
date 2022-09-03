my solution:
```
class Solution:
def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
res = set()
lst= []
def backtrack(lst):
nonlocal res
if len(lst) == n:
val = 0
for num in lst:
val = val * 10 + num
res.add(val)
return
if not lst:
for i in range(1, 10):
lst.append(i)
backtrack(lst)
lst.pop()
else:
prev = lst[-1]
if 0 <= prev + k < 10:
lst.append(prev + k)
backtrack(lst)
lst.pop()
if 0 <= prev - k < 10:
lst.append(prev - k)
backtrack(lst)
lst.pop()
backtrack(lst)
return list(res)
```