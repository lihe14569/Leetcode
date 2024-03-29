class Solution {
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n][5];
        int mod = 1000000007;
        Arrays.fill(dp[n -1], 1);
        //a, e, i, o, u
        for(int i = n - 2; i >= 0; i--) {
            dp[i][0] =  dp[i + 1][1];
            dp[i][1] = (dp[i + 1][0] + dp[i + 1][2]) % mod;
            dp[i][2] = ((dp[i+ 1][0] + dp[i + 1][1]) % mod + (dp[i + 1][3] + dp[i + 1][4]) % mod) % mod;
            dp[i][3] = (dp[i + 1][2] + dp[i + 1][4]) % mod;
            dp[i][4] = dp[i + 1][0];
        }
        return ((dp[0][0] + dp[0][1]) % mod + ((dp[0][2] + dp[0][3]) % mod + dp[0][4]) % mod) % mod;
    }
}