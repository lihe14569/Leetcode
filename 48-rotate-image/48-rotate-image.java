class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return;
        //diagonal flip
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //horizontal flip
        // for(int i = 0; i < n / 2; i++) {
        //     for(int j = 0; j < n; j++) {
        //         int temp = matrix[i][j];
        //         matrix[i][j] = matrix[n - i - 1][j];
        //         matrix[n - i - 1][j] = temp;
        //     }
        // }
        
        //vertical flip
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        
    }
}