二分区间是matrix[0][0]到 matrix[m - 1][n -1 ]二分数大于等于mid point的上区间的最小值
```
class Solution {
public int kthSmallest(int[][] matrix, int k) {
int m = matrix.length, n = matrix[0].length;
int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
while (lo < hi) {
int mid = lo + (hi - lo ) / 2;
int cnt = 0;
for (int i = 0; i < m; i++) {
for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
cnt++;
}
}
if (cnt >= k) hi = mid;
else lo = mid + 1;
}
return lo;
}
}
```