class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return 0;
                
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) {
                    dp[i][j] = 1;
                }
                else if(grid[i-1][j-1] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else dp[i][j] = 0;
            }
        }
        return dp[m][n];
    }
}