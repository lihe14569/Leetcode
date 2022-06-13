python solution:
```
class Solution:
def distributeCookies(self, cookies: List[int], k: int) -> int:
lst = [0 for _ in range(k)]
res = sum(cookies)
l, r = 1, res
def split(i, lst):
nonlocal res
#base case
min_dis = max(lst)
if i == len(cookies):
res = min(res, min_dis)
return
#注意剪枝优化！没有剪枝会超时
if res <= min_dis:
return
#distribute cookie to lst
for j in range(k):
lst[j] += cookies[i]
split(i + 1, lst)
lst[j] -= cookies[i]
split(0, lst)
return res
```