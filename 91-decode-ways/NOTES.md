method1 : iterative dp array
```
class Solution {
public int numDecodings(String s) {
//iterative dp (botton-up method)
if(s.length() == 0) return 1;
int[] dp = new int[s.length() + 1];
dp[0] = 1;
dp[1] = s.charAt(0) == '0' ? 0 : 1;
for(int i = 2; i <= s.length(); i++) {
int twoDigits = Integer.valueOf(s.substring(i - 2, i));
int oneDigit = Integer.valueOf(s.substring(i - 1, i));
if(twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i - 2];
if(oneDigit > 0) dp[i] += dp[i - 1];
}
return dp[s.length()];
}
}
```
​
method2 : recurisve + memo
```
class Solution {
public int numDecodings(String s) {
int[] memo = new int[s.length() + 1];
return helper(s, memo, 0);