class Solution {
    
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }
    public int helper(int n, int[] memo) {
        //base case
        if(n <= 2) return n;
        if(memo[n] != 0) return memo[n];
        memo[n] = helper(n -1, memo) + helper(n - 2, memo);
        return memo[n];
    }
}