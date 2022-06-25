DP solution
​
```
class Solution {
public int distinctSequences(int n) {
int[][][] dp = new int[10010][6][6];
int MOD = 1000000007;
System.out.println(MOD);
//corner case : n == 1
if(n == 1) return 6;
//boundary case: n == 2
for(int i = 0; i < 6; i++) {
for(int j = 0; j < 6; j++) {
if(gcd(i + 1, j + 1) == 1 && i != j)
dp[2][i][j] = 1;
}
}
//dp[i][j][k]:长度为i的倒数第二个数j，第一个数位k的
for(int i = 3; i <= n; i++) {
for(int j = 0; j < 6; j++) {
for(int k = 0; k < 6; k++) {
if(gcd(j + 1, k + 1) == 1 && j != k) {
for(int u = 0; u < 6; u++) {
if(u != j && u != k && gcd(u + 1, j + 1) == 1)
dp[i][j][k] = (dp[i][j][k] + dp[i - 1][u][j]) % MOD;
}
}
}
}
}
int res  = 0;
for(int i = 0; i < 6; i++) {
for(int j = 0; j < 6; j++) {
res = (res + dp[n][i][j]) % MOD;
}
}
return res;
}
public int gcd(int a, int b) {
return b != 0 ? gcd(b, a % b) : a;
}
}
```