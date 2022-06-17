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
//dp
int n = s.length();
int l = 0, r = 0;
boolean[][] dp = new boolean[n][n];
for(int i = n - 1; i >= 0; i--) {
for(int j = i; j < n; j++) {
// j - i <= 2 是确保不会越界
//j - i == 0是一个字母 "a"
//j - i == 1 是两个字母 "aa"
//j - i == 2 是三个字母 "aba",因为前提 s.charAt(i) == s.charAt(j)
if(s.charAt(i) == s.charAt(j) && (j  - i <= 2 || dp[i + 1][j - 1])) {
if(j - i > r - l) {
r = j;
l = i;
}
dp[i][j] = true;
}
}
}
return s.substring(l, r + 1);
}
}
```
​