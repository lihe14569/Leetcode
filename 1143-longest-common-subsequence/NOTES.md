方法一： DP BOTTOM UP
```
public int longestCommonSubsequence(String text1, String text2) {
//dp 双序列 bottom-up
int m = text1.length(), n = text2.length();
int[][] dp = new int[m + 1][n + 1];
for(int i = 1; i <= m; i++) {
for(int j = 1; j <= n; j++) {
if(text1.charAt(i - 1) == text2.charAt(j - 1))
dp[i][j] = dp[i - 1][j - 1] + 1;
else
dp[i][j] = Math.max(dp[i - 1][j], dp[i][j  -1]);
}
}
return dp[m][n];
}
```
​
方法二： DP : DFS+ MEMO
```
public int longestCommonSubsequence(String text1, String text2) {
//TOP DOWN: DFS+ MEMO
int m = text1.length(), n = text2.length();
//小技巧：如果不能确定是否访问的的值，可以用wrapper class
Integer[][] memo = new Integer[m][n];
return dfs(text1, text2, 0, 0, memo);
}
public int dfs(String text1, String text2, int s1, int s2, Integer[][] memo) {
if(s1 >= text1.length() || s2 == text2.length()) return 0;
if(memo[s1][s2] != null) return memo[s1][s2];
if(text1.charAt(s1) == text2.charAt(s2)) {
memo[s1][s2] = 1 + dfs(text1, text2, s1 + 1, s2 + 1, memo);
} else {
memo[s1][s2] = Math.max(dfs(text1, text2, s1 + 1, s2, memo), dfs(text1, text2, s1, s2 + 1, memo));
}
return memo[s1][s2];
}
```