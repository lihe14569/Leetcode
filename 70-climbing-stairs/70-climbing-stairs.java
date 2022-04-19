class Solution {
    Integer[] memo;
    public int climbStairs(int n) {
        memo = new Integer[n + 1];
        return dfs(n);
        
    }
    public int dfs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(memo[n] != null) return memo[n];
        return memo[n] = dfs(n - 1) + dfs(n - 2);
    }
}