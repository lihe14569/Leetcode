JAVA  DP
​
```
class Solution {
public int minPathCost(int[][] grid, int[][] moveCost) {
int m  = grid.length, n = grid[0].length;
int[][] dp = new int[m][n];
for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
for(int i = 0; i < n; i++) dp[0][i] = grid[0][i];
for(int i = 1; i < m; i++) {
for(int j = 0; j < n; j++) {
for(int k = 0; k < n; k++) {
dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i-1][k]][j] + grid[i][j]);
}
}
}
int res = Integer.MAX_VALUE;
for(int val: dp[m-1]) {
res = Math.min(res, val);
}
return res;
}
}
```
​
PYTHON
​