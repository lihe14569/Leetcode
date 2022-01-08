class Solution {
    public int cherryPickup(int[][] grid) {
        //DP + BOOTOM UP
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    int res = 0;
                    //current cell
                    res += grid[i][j];
                    if(j != k) res += grid[i][k];
                    //transition state
                    if(i != m - 1) {
                        int max = 0;
                        for(int l = -1; l <= 1; l++) {
                            for(int r = -1; r <= 1; r++) {
                                int x = j + l, y = k + r;
                                if(x >= 0 && x < n && y >= 0 && y < n) {
                                    max = Math.max(max, dp[i + 1][x][y]);
                                }
                            }
                        }
                        res += max;
                    }
                    dp[i][j][k] = res;
                }
            }
        }
        return dp[0][0][n  - 1];
    }
}