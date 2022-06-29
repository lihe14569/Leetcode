method1: heap to sort interval+ set to record added points
​
```
class SummaryRanges:
​
def __init__(self):
self.intervals = []
self.seen = set()
​
def addNum(self, val: int) -> None:
if val not in self.seen:
self.seen.add(val)
heapq.heappush(self.intervals, [val, val])
​
def getIntervals(self) -> List[List[int]]:
temp = []
while self.intervals:
curr = heapq.heappop(self.intervals)
if temp and temp[-1][1] + 1 >= curr[0]:
temp[-1][1] = max(temp[-1][1], curr[1])
else:
temp.append(curr)
self.intervals = temp
return self.intervals
```
​