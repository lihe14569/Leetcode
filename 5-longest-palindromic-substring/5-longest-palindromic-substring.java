class Solution {
    public String longestPalindrome(String s) {
        //dp动态规划-双序列
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int l = 0, r = 0;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if(j - i > r - l) {
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}