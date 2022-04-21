class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        int n = costs.length;
        for(int j = 0; j < 3; j++) dp[0][j] = costs[0][j];
        for(int i = 1; i < costs.length; i++) {
            for(int j = 0; j <3; j++) {
                if(j == 0) dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][j];
                else if(j ==1) dp[i][j] = Math.min(dp[i- 1][0], dp[i - 1][2]) +costs[i][j];
                else if(j == 2) dp[i][j] = Math.min(dp[i- 1][0], dp[i - 1][1]) +costs[i][j];
            }
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]),dp[n - 1][2]);
    }
}