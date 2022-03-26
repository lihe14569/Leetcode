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
Boolean[] memo = new Boolean[s.length() + 1];
Set<String> set = new HashSet<>(wordDict);
return helper(s, set, memo, 0);