class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        
        for(int i = 0; i < k; i++) dp[0][i] = costs[0][i];
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for(int p = 0; p < k; p++) {
                    if(p == j) continue;
                    min = Math.min(min, dp[i - 1][p]);
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        int res= Integer.MAX_VALUE;
        for(int i = 0; i < k; i++) res = Math.min(res, dp[n - 1][i]);
        return res;
    }
}