class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n]; //indicates ith row longest consecutive block
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                }
                int width = dp[i][j];
                for(int k = i; k >=0; k--) {
                    //要用width更新，因为有效的width一直要保持在k 到i 内最小
                    width = Math.min(width, dp[k][j]);
                    maxArea = Math.max(maxArea, width * (i - k + 1));
                }
            }
        }
        return maxArea;
    }
}