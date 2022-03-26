method1 :bottom-up dp array
```
class Solution {
public boolean wordBreak(String s, List<String> wordDict) {
//dp array
Set<String> set = new HashSet<>(wordDict);
boolean[] dp = new boolean[s.length() + 1];
dp[0] = true; //??? null string is always present in the dictionary
for(int i = 1; i <= s.length(); i++) {
for(int j = 0; j < i; j++) {
if(dp[j] && set.contains(s.substring(j, i)))
dp[i] = true;
}
}
return dp[s.length()];
}
}
```
​
method2: recursion + memo top-down
```
public boolean wordBreak(String s, List<String> wordDict) {
//recursion
//注意!!初始的boolean memo 是wrapper class,以确保没有visited过，避免重复计算
Boolean[] memo = new Boolean[s.length() + 1];
Set<String> set = new HashSet<>(wordDict);
return helper(s, set, memo, 0);
}
public boolean helper(String s, Set<String> set, Boolean[] memo, int start) {
//base case
if(start == s.length()) return true;
if(memo[start] != null) return memo[start];
for(int end = start + 1; end <= s.length(); end++) {
if(set.contains(s.substring(start, end)) && helper(s, set, memo, end))
return memo[start] = true;
}
return memo[start] =false;
}
```