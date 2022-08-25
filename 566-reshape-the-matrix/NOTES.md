​
```
class Solution:
def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
res = [[0]*c for _ in range(r)]
m, n = len(mat), len(mat[0])
if r*c != m *n:
return mat
idx=0
for i in range(r):
for j in range(c):
res[i][j] = mat[idx//n][idx%n]
idx += 1
return res
```