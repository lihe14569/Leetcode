class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        
        int[][] res = new int[r][c];
        if(r * c != m *n) return mat;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <n; j++){
                res[(i * n + j) / c][(i * n + j) % c] = mat[i][j];
            }
        }
        return res;
    }
}