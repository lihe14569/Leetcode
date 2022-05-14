* If anyone is wondering how the bisect works with target as [snap_id + 1], its because the default list comparison (__lt__) is done in a lexicographical manner. First element in both lists is compared, if they are not equal the comparison return True/False depending on the two values. Else, the second elements from both the lists are used, and this continues until one of the lists is exhausted.
​
In our case, i = bisect.bisect(self.A[index], [snap_id + 1]) - 1 will essentially be comparing the first element in each sublist of self.A[index] with snap_id + 1.
​
```
class SnapshotArray:
# list of list
def __init__(self, length: int):
self.dic = [[[-1, 0]] for i in range(length)]
self.snapid = 0
​
def set(self, index: int, val: int) -> None:
if self.dic[index][-1][0] == self.snapid:
self.dic[index][-1][1] = val
else:
self.dic[index].append([self.snapid, val])
​
def snap(self) -> int:
self.snapid += 1
return self.snapid - 1
​
def get(self, index: int, snap_id: int) -> int:
lst = self.dic[index]
i = bisect.bisect(lst, [snap_id + 1]) - 1
return lst[i][1]
​
​
# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
```