BIT->https://leetcode.cn/problems/range-sum-query-mutable/solution/-by-hu-ge-8-t4rn/ 图解
PYTHON SOLTUION
​
```
class BIT:
def __init__(self, size):
self.sums = [0]*(size + 1)
def lowbit(self, x):
return x & (-x)
def getSum(self, i):
s = 0
while i > 0:
s += self.sums[i]
i -= self.lowbit(i)
return s
def getSumRange(self, l, r):
return self.getSum(r) - self.getSum(l - 1)
def insert(self, i, val):
while i < len(self.sums):
self.sums[i] += val
i += self.lowbit(i)
class NumArray:
​
def __init__(self, nums: List[int]):
self.nums = nums
self.BIT = BIT(len(nums))
for i, val in enumerate(nums):
self.BIT.insert(i + 1, val)
def update(self, index: int, val: int) -> None:
diff = val - self.nums[index]
class BIT { // one-based indexing