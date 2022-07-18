class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        s = ' ' + s;
        p = ' ' + p;
        dp[0][0] = true;
        for(int i = 0; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(j + 1 <= n && p.charAt(j + 1) == '*') continue;
                if(i != 0 && p.charAt(j) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                } else if(p.charAt(j) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i != 0 && dp[i - 1][j] && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'));
                }
            }
        }
        return dp[m][n];
    }
}