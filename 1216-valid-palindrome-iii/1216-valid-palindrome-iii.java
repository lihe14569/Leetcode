class Solution {
    public boolean isValidPalindrome(String s, int k) {
        //dp
        int[][] dp = new int[s.length()][s.length()];
        
        for(int i= s.length() - 2; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1] <= k;
    }
}