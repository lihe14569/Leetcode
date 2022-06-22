merge interval考虑三种情况
1. 当前区间补充和new
```
def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
intervals.sort(key= lambda x : x[0])
res=[]
for curr in intervals:
if newInterval is None or curr[1] < newInterval[0]:
res.append(curr)
elif curr[0] > newInterval[1]:
res.append(newInterval)
res.append(curr)
newInterval = None
else:
newInterval[0] = min(curr[0], newInterval[0])
newInterval[1] = max(curr[1], newInterval[1])
if newInterval is not None: res.append(newInterval)
return res
```
​
java
```
public int[][] insert(int[][] intervals, int[] ni) {
List<int[]> list = new ArrayList<>();