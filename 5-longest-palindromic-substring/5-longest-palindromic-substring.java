class Solution {
    public String longestPalindrome(String s) {
        //dp
        int n = s.length();
        int l = 0, r = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j  - i <= 2 || dp[i + 1][j - 1])) {
                    if(j - i > r - l) {
                        r = j;
                        l = i;
                    }
                    dp[i][j] = true;
                }
            }
        }
        return s.substring(l, r + 1);
    }
}