for(int j = 0; j < n; j++) {
if(i < 0 || i >= m || j < 0 || j >= n || k < 0 || k >= n) return 0;
//判断是否已经计算过
if(memo[i][j][k] != -1) return memo[i][j][k];
//当前cell
res += grid[i][j];
if(j != k) res += grid[i][k];
//判断是否为base case : 到达最后一行
if(i == m - 1) {
memo[i][j][k] = res;
return res;
}
//transition function:找到下一行的最大组合
int max = 0;
for(int l = -1; l <= 1; l++) {
for(int r = -1; r <= 1; r++) {
max = Math.max(max, dp(grid, memo, i + 1, j + l, k + r));
}
}
res += max;
//存入memo
memo[i][j][k] = res;
return res;
}
```
​
方法二：DP + BOTTOM UP
​
​