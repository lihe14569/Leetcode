方法一： 中心扩展法
```
class Solution {
public String longestPalindrome(String s) {
String res = "";
int l = 0, r = 0;
for(int i = 0; i < s.length() - 1; i++) {
int len1 = panlindrome(s, i, i);
int len2 = panlindrome(s, i, i + 1);
int len = Math.max(len1, len2);
if(len > r - l) {
//for odd length, (len -1) /2 is the left mid point of panlindrome, len /2 is right mid point
//for even length, len/2 and (len - 1) /2 is same mid point
l = i - (len - 1) / 2;
r = i + len/ 2;
}
}
return s.substring(l, r + 1);
}
public int panlindrome(String s, int l , int r) {
while(l >= 0 && r < s.length()) {
if(s.charAt(l) == s.charAt(r)) {
l--;
r++;
} else break;
}
return r - l - 1;
}
}
```
​
方法二： DP
```
public String longestPalindrome(String s) {
int n = s.length();
boolean[][] dp = new boolean[n][n];
int l = 0, r = 0;
for(int i = n - 1; i >= 0; i--) {
for(int j = i; j < n; j++) {
if((s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1])) {
if(j - i > r - l) {
l = i;
r = j;
}
dp[i][j] = true;
}
}
}
return s.substring(l, r + 1);
}
```