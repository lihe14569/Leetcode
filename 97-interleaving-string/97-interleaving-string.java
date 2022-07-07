class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 && j == 0) dp[i][j] = true;
                else {
                    if(i > 0 && s1.charAt(i) == s3.charAt(i + j)) dp[i][j] = dp[i - 1][j];
                    if(j > 0 && s2.charAt(j) == s3.charAt(i + j)) dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}