方法一：
```
def removeOnes(self, grid: List[List[int]]) -> bool:
m, n = len(grid), len(grid[0])
row1 = grid[0]
rev_row1 = [1 - x for x in grid[0]]
for i in range(1, m):
if row1 != grid[i] and rev_row1 != grid[i]:
return False
return True
```
1. For each row or col, we only need to flip it once or do not flip. (Flip 2, 4, 6,.. times is same as not flip; flip 1, 3, 5, .. times is same as flip once);
2. The order of flipping does not matter.
3. If after some flips, we can get the all-zero matrix. Then for each pair of rows (or cols), they must be exactly same (every element is the same) or completely different (every element is different).
​