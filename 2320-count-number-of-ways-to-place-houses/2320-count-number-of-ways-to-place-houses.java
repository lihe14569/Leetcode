class Solution {
    public int countHousePlacements(int n) {
        int[][] dp = new int[n + 1][2];
        int MOD = 1000000007;
        dp[1][0] = 1;
        dp[1][1] = 1;
        for(int i = 2; i <=n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = dp[i - 1][0];
        }
        long res = (dp[n][1] + dp[n][0]) % MOD;
        return (int)(res * res % MOD);
    }
}