class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        
        int[][] res = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int val = 0;
                for(int p = -k; p <= k; p++) {
                    for(int q = -k; q <= k; q++) {
                        int x = i + p;
                        int y = j + q;
                        if(x >= 0 && x < m && y >= 0 && y < n) {
                            val += mat[x][y];
                        }
                    }
                }
                res[i][j] = val;
            }
        }
        return res;
    }
}