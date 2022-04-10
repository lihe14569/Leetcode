method1 dfs + memo
```
class Solution {
Integer[] memo;
public int numTrees(int n) {
memo = new Integer[n];
return dfs(1, n, memo);
}
public int dfs(int start, int end, Integer[] memo) {
//base case
if(start >= end) return 1;
//memo void repeat calculation
if(memo[end - start] != null) return memo[end - start];
//
int res = 0;
for(int i = start; i <= end; i++) {
res += dfs(start, i - 1, memo) * dfs(i + 1, end, memo);
}
return memo[end -start] = res;
}
}
```