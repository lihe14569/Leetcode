class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;
        
        int[][] ans = new int[m][n];
        
        for(int row = 0; row < m; row++) {
            for(int eIndex =  0; eIndex < k; eIndex++)
                if(mat1[row][eIndex] != 0) {
                    for(int col = 0; col < n; col++) {
                        ans[row][col] += mat1[row][eIndex] * mat2[eIndex][col];
                    }
                }
        }
        return ans;
    }
}