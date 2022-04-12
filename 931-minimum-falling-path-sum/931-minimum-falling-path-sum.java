class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        
        for(int i = 0; i < n; i++) dp[i] = matrix[0][i];
        
        for(int i = 1; i < m; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < n; j++) {
                if(j == 0) {
                    temp[j] = Math.min(dp[j], dp[j + 1]);
                } else if(j == n - 1) {
                    temp[j] = Math.min(dp[j - 1], dp[j]);
                } else {
                    temp[j] = Math.min(dp[j - 1], Math.min(dp[j], dp[j + 1]));
                }
                temp[j] += matrix[i][j];
            }
            dp = temp;
        }
        int res = Integer.MAX_VALUE;
        for(int val : dp) res= Math.min(val, res);
        return res;
    }
}