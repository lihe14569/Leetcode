class Solution {
    public int minimumDeletions(String s) {
        int bcount = 0;
        int[] dp = new int[s.length() + 1];
        for(int i = 1; i <= s.length(); i++) {
            if(s.charAt(i - 1) == 'a') {
                dp[i] = Math.min(dp[i- 1] + 1, bcount);
            } else {
                dp[i] = dp[i - 1];
                bcount++;
            }
        }
        return dp[s.length()];
    }
}