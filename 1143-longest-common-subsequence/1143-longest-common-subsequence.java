class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //TOP DOWN: DFS+ MEMO
        int m = text1.length(), n = text2.length();
        //小技巧：如果不能确定是否访问的的值，可以用wrapper class
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            Arrays.fill(memo[i], -1);
            memo[i][0] = 0;
        }
        
        return dfs(text1, text2, m, n, memo);
    }
    
    public int dfs(String text1, String text2, int i, int j, int[][] memo) {
        if(i <= 0 || j <= 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
            memo[i][j] = 1 + dfs(text1, text2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(dfs(text1, text2, i - 1, j, memo), dfs(text1, text2, i, j - 1, memo));
        }
        return memo[i][j];
    }
}