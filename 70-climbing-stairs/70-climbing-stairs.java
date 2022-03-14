class Solution {
    public int climbStairs(int n) {
        Integer[] memo = new Integer[n + 1];
        return dfs(n, memo);
    }
    public int dfs(int n, Integer[] memo) {
        //base case
        if(n == 0 || n == 1) return 1;
        //check memo
        if(memo[n] != null) return memo[n];
        int step = dfs(n - 1, memo) + dfs(n - 2, memo);
        memo[n] = step;
        return step;
    }
}