方法一： DP
```
public int countSubstrings(String s) {
//dp
int n = s.length();
boolean[][] dp = new boolean[n][n];
int res = 0;
for(int i = n - 1; i >= 0; i--) {
for(int j = i; j < n; j++) {
dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
if(dp[i][j]) res++;
}
}
return res;
}
```
​
方法二： 中心扩散
```
​
```