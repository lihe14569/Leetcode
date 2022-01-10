class Solution {
    public int longestPalindromeSubseq(String s) {
        //DFS+memo
        int n = s.length();
        int[][] memo = new int[n][n];
        return dfs(s, memo, 0, n - 1);
    }
    
    public int dfs(String s, int[][] memo, int l, int r) {
        //base case
        if(l > r) return 0;
        if(l == r) return 1;
        //check if we already calculate
        if(memo[l][r] > 0) return memo[l][r];
        //transition
        if(s.charAt(l) == s.charAt(r)) memo[l][r] = dfs(s, memo, l + 1, r -1) + 2;
        else memo[l][r] = Math.max(dfs(s, memo, l + 1, r), dfs(s, memo, l, r - 1));
        return memo[l][r];
    }
}