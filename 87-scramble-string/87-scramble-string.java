class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        for(int k = 1; k <= n; k++) {
            for(int i = 0; i + k - 1 < n; i++) {
                for(int j = 0; j + k - 1 < n; j++) {
                    if(k == 1) {
                        if(s1.charAt(i) == s2.charAt(j))
                            dp[i][j][k] = true;
                    } else {
                        for(int u = 1; u < k; u++) {
                            if((dp[i][j][u] && dp[i + u][j + u][k - u]) ||
                              (dp[i][j + k - u][u] && dp[i + u][j][k - u])) {
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}