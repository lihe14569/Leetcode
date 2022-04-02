# **Method1**
**top- down + recurison + memo**
```
class Solution {
Integer[][] memo;
public boolean isValidPalindrome(String s, int k) {
memo = new Integer[s.length()][s.length()];
return isValid(s, 0, s.length() - 1) <= k;
}
public int isValid(String s, int l, int r) {
//base case
if(l == r) return 0;
if(l == r - 1) return s.charAt(l) == s.charAt(r) ? 0 : 1;
//check memo
if(memo[l][r] != null) return memo[l][r];
//case1 : l 和r指的字母相同
if(s.charAt(l) == s.charAt(r)) return memo[l][r] = isValid(s, l + 1, r - 1);
//case2 : l 和r指的字母不同
else {
return memo[l][r] = 1 + Math.min(isValid(s, l + 1, r), isValid(s, l, r - 1));
}
}
}
```
​
Method2 : Bottom-up
```
​
```
​
​