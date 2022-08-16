**差分算法**
差分的prefixSum(index 0到 i) 就是 原数组元素 a[i]
检查尾元素 j + 1 是否越界，越界证明从i以后所有元素都要进行 += val操作，不需要 -=val在区间后端
​
```
def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
diff = [0] * length
​
for u in updates:
i, j, val = u
diff[i] += val
if j + 1 < length:
diff[j + 1] -= val
for i in range(1, length):
diff[i] += diff[i - 1]
return diff
```