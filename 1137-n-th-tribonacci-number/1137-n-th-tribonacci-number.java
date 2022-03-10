class Solution {
    
    public int tribonacci(int n) {
        Integer[] memo = new Integer[n + 1];
        return dfs(n, memo);
    }
    public int dfs(int n, Integer[] memo) {
        if(n < 3) {
            if(n == 0) return 0;
            if(n == 1) return 1;
            if(n == 2) return 1;
        }
        if(memo[n] != null) return memo[n];
        int val = dfs(n -3, memo) + dfs(n -2, memo) + dfs(n - 1, memo);
        return memo[n] = val;
    }
}