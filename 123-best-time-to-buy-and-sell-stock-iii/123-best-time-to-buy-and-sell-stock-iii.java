class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2]; //tricky 小技巧avoid index out of bound
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < 3; j++) {
                if(i == 0) {
                    dp[i][j][0] = -prices[0];
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
                }
            }
        }
        return dp[n - 1][2][1];
    }
}