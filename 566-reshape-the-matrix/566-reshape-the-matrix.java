class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        
        int[][] res = new int[r][c];
        if(r * c != m *n) return mat;
        int idx = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++){
                res[i][j] = mat[idx / n][idx % n];
                idx++;
            }
        }
        return res;
    }
}